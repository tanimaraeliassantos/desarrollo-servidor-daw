package seguridad.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection="usuarios")

public class Usuario {
	@Id
	private String id;
	private String nombre;
	private String email;
	private String password;
	private String rol; //EMPRESA | CONDUCTOR
}


