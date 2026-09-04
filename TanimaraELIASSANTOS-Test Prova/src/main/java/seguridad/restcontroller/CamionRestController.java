package seguridad.restcontroller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import seguridad.model.entity.Camion;
import seguridad.model.service.CamionService;

@RestController
@RequestMapping("/api/camiones")
public class CamionRestController {
	private final CamionService camionService;
	
	public CamionRestController(CamionService camionService) {
		this.camionService = camionService;
	}
	
	@PutMapping("/{camionId}/asignar/{conductorId}")
	public ResponseEntity<?> asignarAConductor(
			@PathVariable String camionId,
			@PathVariable String conductorId) {
		Optional<Camion> resultado = camionService.asignarAConductor(camionId, conductorId);
		
		if(resultado.isPresent()) {
			return ResponseEntity.ok(resultado.get());
		} else {
			return ResponseEntity.badRequest().body("No se puede asignar.");
		}
	}

}
