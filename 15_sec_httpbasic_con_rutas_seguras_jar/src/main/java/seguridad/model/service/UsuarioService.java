package seguridad.model.service;

import seguridad.model.entity.Usuario;

public interface UsuarioService {
	
	Usuario buscarUsuario(String username);
	Usuario buscarPorUsernamePassword(String username, String password);
	Usuario altaUsuario(Usuario usuario);
	
	
}
