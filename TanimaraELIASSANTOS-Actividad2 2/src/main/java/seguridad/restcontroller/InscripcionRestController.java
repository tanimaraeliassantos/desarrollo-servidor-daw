package seguridad.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import seguridad.model.dto.InscripcionDTO;
import seguridad.model.entity.Inscripcion;
import seguridad.model.service.InscripcionService;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionRestController {
	@Autowired
	private InscripcionService service;
	
	@PostMapping("/apuntarse")
	@PreAuthorize("hasRole('CONDUCTOR')")
	public Inscripcion apuntarse(@RequestBody InscripcionDTO dto, Authentication auth) {
		return service.inscribirCamion(dto,  auth.getName());
	}
	
	@PatchMapping("/{id}/decidir")
	@PreAuthorize("hasAuthority('EMPRESA')")
	public ResponseEntity<Inscripcion> decidir(
			@PathVariable String id,
			@RequestParam String estado) {
		Inscripcion actualizada = service.decidirInscripcion(id, estado);
		return ResponseEntity.ok(actualizada);
	}

}
