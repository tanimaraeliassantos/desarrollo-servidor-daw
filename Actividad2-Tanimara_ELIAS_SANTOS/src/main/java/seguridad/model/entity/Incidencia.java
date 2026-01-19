package seguridad.model.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="incidencias")
public class Incidencia {
	@Id
	private String id;
	private String camionId;
	private String descripcion;
	private LocalDate fecha;
	private String tipo; //MECANICA | METEOROLOGICA | DOCUMENTAL
	private String estado; // ABIERTA | RESUELTA

}
