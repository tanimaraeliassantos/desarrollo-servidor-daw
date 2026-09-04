package seguridad.model.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import seguridad.model.dto.CapacidadTotalDTO;
import seguridad.model.entity.Camion;
import seguridad.model.entity.Usuario;
import seguridad.model.repository.CamionRepository;
import seguridad.model.repository.UsuarioRepository;

@Service
public class CamionServiceImpl implements CamionService{
	
	private final CamionRepository camionRepository;
	private final UsuarioRepository usuarioRepository;
	
	public CamionServiceImpl(CamionRepository camionRepository, UsuarioRepository usuarioRepository) {
		this.camionRepository = camionRepository;
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Optional<Camion> asignarAConductor(String camionId, String conductorId) {
		Optional<Usuario> conductorOpt = usuarioRepository.findById(conductorId);
		if(conductorOpt.isEmpty() || !"CONDUCTOR".equals(conductorOpt.get().getRol())) {
			return Optional.empty();
		}
		Optional<Camion> camionOpt = camionRepository.findById(camionId);
		if(camionOpt.isEmpty()) {
			return Optional.empty();
		}
		
		Camion camion = camionOpt.get();
		camion.setConductorId(conductorId);
		camionRepository.save(camion);
		
		return Optional.of(camion);
	}

	@Override
	public CapacidadTotalDTO obtenerCapacidadTotalPorConductor(String conductorId) {

	    Optional<Usuario> conductorOpt = usuarioRepository.findById(conductorId);
	    if (conductorOpt.isEmpty() || !"CONDUCTOR".equals(conductorOpt.get().getRol())) {
	        return new CapacidadTotalDTO(conductorId, 0, 0);
	    }
	  
	    List<Camion> camionesDelConductor = camionRepository.findByConductorId(conductorId);
	    
	    List<Camion> camionesActivos = camionesDelConductor.stream()
	        .filter(c -> "activo".equalsIgnoreCase(c.getEstado()))
	        .collect(Collectors.toList());
	    	  
	    int capacidadTotal = camionesActivos.stream()
	        .mapToInt(Camion::getCapacidadKg)
	        .sum();
	    	 
	    return new CapacidadTotalDTO(
	        conductorId,
	        capacidadTotal,
	        camionesActivos.size()
	    );
	}

}
