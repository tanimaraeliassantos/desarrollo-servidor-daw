package seguridad.model.service;

import java.util.List;

import seguridad.model.entity.Inscripcion;

public interface InscripcionService {
	Inscripcion inscribirCamion(String camionId, String mercanciaId);
	
	List<Inscripcion> listarPorMercancia(String mercanciaId);
}
