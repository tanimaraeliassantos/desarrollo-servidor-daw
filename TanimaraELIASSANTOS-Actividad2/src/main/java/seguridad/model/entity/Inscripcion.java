package seguridad.model.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="inscripciones")
public class Inscripcion {
	@Id
	private String id;
	private String camionId;
	private String mercanciaId;
	private LocalDate fechaInscripcion;
	private String estado; //PENDIENTE | ACEPTADA | RECHAZADA
}
