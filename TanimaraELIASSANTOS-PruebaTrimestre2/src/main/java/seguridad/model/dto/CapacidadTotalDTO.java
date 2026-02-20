package seguridad.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CapacidadTotalDTO {
	private String conductorId;
	private int capacidadTotalKg;
	private int numeroCamionesActivos;

}
