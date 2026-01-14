package seguridad.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import seguridad.model.entity.Usuario;
import seguridad.model.service.UsuarioService;

@CrossOrigin(origins="*")
@RestController
public class HomeRestController {
	@Autowired
	private UsuarioService uservice;
	
	@GetMapping("/")
	public ResponseEntity<?> home() {
		return ResponseEntity.ok("Te doy la bienvenida invitado");
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UsuarioLoginDto usuDto) {
		Usuario usuario = uservice.buscarPorUsernamePassword(usuDto.getUsername(), "{noop}" + usuDto.getPassword());
		if(usuario !=null) {
			usuario.setPassword(null);
			return ResponseEntity.ok(usuario);
		}
		else
			return ResponseEntity.status(400).body("Usuario o contraseñas incorrectas");
		
	}
}
