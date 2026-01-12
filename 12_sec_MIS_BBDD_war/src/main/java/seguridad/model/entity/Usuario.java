package seguridad.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data @Builder @EqualsAndHashCode()

public class Usuario {
	private String username;
	private String password;
	private String nombre;
	private int enabled;

}
