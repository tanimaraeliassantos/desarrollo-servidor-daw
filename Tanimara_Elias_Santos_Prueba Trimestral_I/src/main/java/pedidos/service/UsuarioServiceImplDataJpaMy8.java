package pedidos.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pedidos.modelo.entities.Usuario;
import pedidos.modelo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImplDataJpaMy8 implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario buscarUno(int idUsuario) {
		return usuarioRepository.findById(idUsuario).orElse(null);
	}

	@Override
	public List<Usuario> findByEmailContaining(String texto) {
		return usuarioRepository.findByEmailContaining(texto);
	}

	@Override
	public List<Usuario> findByFechaRegistroAfter(LocalDate fecha) {
		return usuarioRepository.findByFechaRegistroAfter(fecha);
	}
	
	
	

}
