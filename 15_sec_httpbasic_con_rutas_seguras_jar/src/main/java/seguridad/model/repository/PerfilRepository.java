package seguridad.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import seguridad.model.entity.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
	
	public Perfil findByNombre(String nombre);

}
