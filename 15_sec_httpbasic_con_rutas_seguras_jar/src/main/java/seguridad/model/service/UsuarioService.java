package seguridad.model.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import seguridad.model.entity.Usuario;

public interface UsuarioService extends UserDetailsService{
	
	Usuario buscarUsuario(String username);
	Usuario buscarPorUsernamePassword(String username, String password);
	Usuario altaUsuario(Usuario usuario);
	
	
}
