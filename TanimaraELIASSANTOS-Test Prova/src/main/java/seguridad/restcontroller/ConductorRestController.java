package seguridad.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import seguridad.model.dto.CapacidadTotalDTO;
import seguridad.model.service.CamionService;

@RestController
@RequestMapping("/api/conductores")
public class ConductorRestController {
	
	private final CamionService camionService;
	
	public ConductorRestController(CamionService camionService) {
		this.camionService = camionService;
	}
	
	@GetMapping("/{conductorId}/capacidad-total")
    public ResponseEntity<CapacidadTotalDTO> obtenerCapacidadTotal(
            @PathVariable String conductorId) {
        
        CapacidadTotalDTO resultado = camionService.obtenerCapacidadTotalPorConductor(conductorId);
        return ResponseEntity.ok(resultado);
    }
	

}
