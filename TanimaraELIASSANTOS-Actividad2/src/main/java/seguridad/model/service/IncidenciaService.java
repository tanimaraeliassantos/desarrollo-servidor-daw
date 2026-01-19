package seguridad.model.service;

import java.util.List;

import seguridad.model.dto.IncidenciaDTO;
import seguridad.model.entity.Incidencia;

public interface IncidenciaService {
	Incidencia reportar(IncidenciaDTO Dto);
	List<Incidencia> listarPorCamion(String camionId);
}
