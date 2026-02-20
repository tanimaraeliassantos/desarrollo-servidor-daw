package seguridad.model.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="mercancias")

public class Mercancia {
	@Id
	private String id;
	private String descripcion;
	private String origen;
	private String destino;
	private Double pesoKg;
	private LocalDate fechaEntregaEstimada;
	private String estado; //PENDIENTE | ASIGNADA | ENTREGADA

}
