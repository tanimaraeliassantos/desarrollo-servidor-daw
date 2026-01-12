package seguridad.restcontroller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/saludar")
public class SaludoRestController {
	
	@GetMapping("/hola")
	public String hola(Authentication auth) {
		return "Hola " + auth.getName() + " - " + auth.toString();
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
