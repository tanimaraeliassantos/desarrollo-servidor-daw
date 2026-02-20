package seguridad.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import seguridad.model.dto.IncidenciaDTO;
import seguridad.model.entity.Incidencia;
import seguridad.model.service.IncidenciaService;

@RestController
@RequestMapping("/api/incidencias")
public class IncidenciaRestController {
	
	@Autowired
	private IncidenciaService service;
	
	@PostMapping("/reportar")
	@PreAuthorize("hasRole('CONDUCTOR')")
	public ResponseEntity<Incidencia> reportar(@RequestBody IncidenciaDTO incidenciaDTO) {
		Incidencia nueva = service.reportar(incidenciaDTO);
		return new ResponseEntity<>(nueva, HttpStatus.CREATED);
	}

}
