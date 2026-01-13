package seguridad.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import seguridad.model.entity.Usuario;
import seguridad.model.repository.UsuarioRepository;
@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario buscarUsuario(String username) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(username).orElse(null);
	}
	@Override
	public Usuario buscarPorUsernamePassword(String username, String password) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByUsernameAndPassword(username, password);
	}
	@Override
	public Usuario altaUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(usuario);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(username).orElse(null);
	}

}
