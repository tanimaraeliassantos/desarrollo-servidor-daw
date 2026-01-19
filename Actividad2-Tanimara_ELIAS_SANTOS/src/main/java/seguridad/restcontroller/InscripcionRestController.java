package seguridad.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import seguridad.model.entity.Inscripcion;
import seguridad.model.service.InscripcionService;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionRestController {
	@Autowired
	private InscripcionService service;
	
	@PostMapping("/apuntarse")
	@PreAuthorize("hasRole('CONDUCTOR')")
	public Inscripcion apuntarse(
			@RequestParam String camionId,
			@RequestParam String mercanciaId) {
		return service.inscribirCamion(camionId, mercanciaId);
	}

}
