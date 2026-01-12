package seguridad.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data @ Builder
@EqualsAndHashCode(of = "username")
@Entity
@Table(name="USUARIOS")
public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	private String username;
	private String password;
	private String nombre;
	private int enabled;
	
	@ManyToMany
	@JoinTable(
			name="USUARIO_PERFILES"
			, joinColumns =	@JoinColumn(name="USERNAME")
			, inverseJoinColumns = @JoinColumn(name="ID_PERFIL")
			)
	private List<Perfil> perfiles;
	
	

}
