package pedidos.service;

import java.time.LocalDate;
import java.util.List;

import pedidos.modelo.entities.Usuario;

public interface UsuarioService {
	Usuario buscarUno(int idUsuario);
	List<Usuario> findByEmailContaining(String texto);
	List<Usuario> findByFechaRegistroAfter(LocalDate fecha);

}
