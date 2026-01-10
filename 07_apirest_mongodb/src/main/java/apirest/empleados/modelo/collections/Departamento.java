package apirest.empleados.modelo.collections;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Departamento {
	private String nombre;
	
	@Field("ubicación")
	private String ubicacion;
}
