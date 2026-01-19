package seguridad.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="camiones")
public class Camion {

	@Id
	private String id;
	private String conductorId;
	private String matricula;
	private String modelo;
	private int capacidadKg;
	private String estado; //ACTIVO | INACTIVO
}
