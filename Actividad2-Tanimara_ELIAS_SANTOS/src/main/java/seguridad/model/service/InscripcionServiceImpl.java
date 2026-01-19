package seguridad.model.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seguridad.model.entity.Inscripcion;
import seguridad.model.repository.InscripcionRepository;

@Service
public class InscripcionServiceImpl implements InscripcionService{
		@Autowired
		private InscripcionRepository repo;

	@Override
	public List<Inscripcion> listarPorMercancia(String mercanciaId) {
		return repo.findByMercanciaId(mercanciaId);
	}

	@Override
	public Inscripcion inscribirCamion(String camionId, String mercanciaId) {
		Inscripcion nueva = new Inscripcion();
		
		nueva.setCamionId(camionId);
		nueva.setMercanciaId(mercanciaId);
		
		nueva.setFechaInscripcion(LocalDate.now());
		nueva.setEstado("PENDIENTE");
		
		return repo.save(nueva);
	}

}
