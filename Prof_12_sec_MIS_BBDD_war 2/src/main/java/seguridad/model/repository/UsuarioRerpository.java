package seguridad.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import seguridad.model.entity.Usuario;

public interface UsuarioRerpository extends JpaRepository<Usuario, String>{
	
	public Usuario findByUsernameAndPassword(String username, String password);

}
