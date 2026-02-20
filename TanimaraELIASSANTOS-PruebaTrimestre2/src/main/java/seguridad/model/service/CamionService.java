package seguridad.model.service;

import java.util.Optional;

import seguridad.model.dto.CapacidadTotalDTO;
import seguridad.model.entity.Camion;

public interface CamionService {
	Optional<Camion> asignarAConductor(String camionId, String conductorId);
	CapacidadTotalDTO obtenerCapacidadTotalPorConductor(String conductorId);
}
