package seguridad.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import seguridad.model.entity.Mercancia;
import seguridad.model.service.IMercanciaService;

@RestController
@RequestMapping("/api/mercancias")
public class MercanciaRestController {
	
	@Autowired
	private IMercanciaService mercanciaService;
	
	@GetMapping("/disponibles")
	public List<Mercancia> listarPendientes() {
		return mercanciaService.listarPendientes();
	}
	
	@GetMapping("/buscar")
	public List<Mercancia> buscar(
			@RequestParam(required = false) String origen,
			@RequestParam(required = false) String destino,
			@RequestParam(required = false) Double pesoMax) {
		return mercanciaService.buscarPorFiltros(origen, destino, pesoMax);
	}
	
	@PostMapping("/crear")
	@PreAuthorize("hasRole('EMPRESA')")
	public ResponseEntity<Mercancia> crear(@RequestBody Mercancia mercancia) {
		Mercancia nueva = mercanciaService.guardar(mercancia);
		return new ResponseEntity<>(nueva, HttpStatus.CREATED);
	}
		

}
