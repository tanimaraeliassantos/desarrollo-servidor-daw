package seguridad.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data @Builder @EqualsAndHashCode(of="username")
@Entity
@Table(name="USUARIOS")
public class Usuario implements Serializable, UserDetails{
	
	private static final long serialVersionUID = 1L;
	@Id
	private String username;
	private String password;
	private String nombre;
	private int enabled;
	
	@ManyToMany
	@JoinTable(
			name="USUARIO_PERFILES"
			, joinColumns = @JoinColumn(name="USERNAME")
			, inverseJoinColumns = @JoinColumn(name="ID_PERFIL")
			)
	private List<Perfil> perfiles;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return perfiles.stream()
				.map(p -> new SimpleGrantedAuthority(p.getNombre()))
				.toList();
	}
	

}
