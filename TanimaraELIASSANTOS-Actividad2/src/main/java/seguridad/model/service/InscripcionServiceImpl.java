package seguridad.model.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import seguridad.model.dto.InscripcionDTO;
import seguridad.model.entity.Inscripcion;
import seguridad.model.repository.InscripcionRepository;
import seguridad.model.repository.MercanciaRepository;

@Service
public class InscripcionServiceImpl implements InscripcionService {
    
    @Autowired
    private InscripcionRepository repo;
    
    @Autowired
    private MercanciaRepository mercanciaRepo;

	@Override
	public Inscripcion inscribirCamion(InscripcionDTO dto, String emailConductor) {
		return mercanciaRepo.findById(dto.getIdMercancia()).map(m -> {
			
			if ("asignada".equalsIgnoreCase(m.getEstado())) {
				throw new RuntimeException("Error: esta mercancia ya ha sido asignada.");
			}
			
			m.setEstado("asignada");
			mercanciaRepo.save(m);
				
		Inscripcion nueva = new Inscripcion();
		nueva.setMercanciaId(dto.getIdMercancia());
		nueva.setCamionId(dto.getIdCamion());
		nueva.setFechaInscripcion(LocalDate.now());
		nueva.setEstado("pendiente");
		
		return repo.save(nueva);
	}).orElseThrow(() ->new RuntimeException("Error: no se encontro la mercancia."));
	}

	@Override
	public List<Inscripcion> listarPorMercancia(String mercanciaId) {
		return repo.findByMercanciaId(mercanciaId);
	}

	@Override
	public Inscripcion decidirInscripcion(String idInscripcion, String nuevoEstado) {
		return repo.findById(idInscripcion).map(ins-> {
			ins.setEstado(nuevoEstado.toUpperCase());
			
			if("rechazada".equalsIgnoreCase(nuevoEstado)) {
				mercanciaRepo.findById(ins.getMercanciaId()).ifPresent(m -> {
					m.setEstado("pendiente");
					mercanciaRepo.save(m);
				});
			}
			else if ("aceptada".equalsIgnoreCase(nuevoEstado)) {
				mercanciaRepo.findById(ins.getMercanciaId()).ifPresent(m -> {
					m.setEstado("asignada");
					mercanciaRepo.save(m);
				});
			}
			return repo.save(ins);
		}).orElseThrow(()-> new RuntimeException("Inscripcion no encontrada"));
	}
}
