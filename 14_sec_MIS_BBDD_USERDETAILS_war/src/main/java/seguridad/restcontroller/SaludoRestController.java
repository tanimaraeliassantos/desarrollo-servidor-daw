package seguridad.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import seguridad.model.entity.Usuario;
import seguridad.model.repository.UsuarioRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/saludar")
public class SaludoRestController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/hola")
	public String hola(Authentication auth, HttpSession misesion) {
		
		Usuario usuario = usuarioRepository.findById(auth.getName()).orElse(null);
		usuario.setPassword(null);
		misesion.setAttribute("usuario", usuario);
		
		return "Hola " + auth.getName() + " - " + auth + "---" + usuario;
	}
	
	@GetMapping("/adios")
	public String adios() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return "Hasta la vista babe " + auth.getName() + " - " + auth.getDetails();
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "Sesion cerrada";
	}
	
}
