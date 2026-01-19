package seguridad.model.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seguridad.model.dto.IncidenciaDTO;
import seguridad.model.entity.Incidencia;
import seguridad.model.repository.IncidenciaRepository;

@Service
public class IncidenciaServiceImpl implements IncidenciaService{
	@Autowired
	private IncidenciaRepository repo;
	
	@Override
	public Incidencia reportar(IncidenciaDTO dto) {
		Incidencia nueva = new Incidencia();
		
		nueva.setMercanciaId(dto.getMercanciaId());
		nueva.setCamionId(dto.getCamionId());
		nueva.setDescripcion(dto.getDescripcion());
		
		nueva.setFecha(LocalDate.now());
		nueva.setEstado("abierta");
		nueva.setTipo("mecanica");
		return repo.save(nueva);
	}

	@Override
	public List<Incidencia> listarPorCamion(String camionId) {
		return repo.findByCamionId(camionId);
	}
	
}
