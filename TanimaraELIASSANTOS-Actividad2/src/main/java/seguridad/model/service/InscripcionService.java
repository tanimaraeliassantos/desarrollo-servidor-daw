package seguridad.model.service;

import java.util.List;

import seguridad.model.dto.InscripcionDTO;
import seguridad.model.entity.Inscripcion;

public interface InscripcionService {
	Inscripcion inscribirCamion(InscripcionDTO dto, String emailConductor);
	Inscripcion decidirInscripcion(String idInscripcion, String nuevoEstado);
	List<Inscripcion> listarPorMercancia(String mercanciaId);

}
