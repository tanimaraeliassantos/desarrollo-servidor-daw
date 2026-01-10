package pedidos.modelo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pedidos.modelo.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	public List<Usuario> findByEmailContaining(String texto);
	List<Usuario> findByFechaRegistroAfter(LocalDate fecha);

}
