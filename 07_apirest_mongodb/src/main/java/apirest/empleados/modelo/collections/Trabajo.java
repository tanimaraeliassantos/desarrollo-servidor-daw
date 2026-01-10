package apirest.empleados.modelo.collections;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Field;

public class Trabajo {
	private String titulo;
	private BigDecimal salario;
	@Field("fecha_inicio")
	private LocalDate fechaInicio;
	
	private BigDecimal bonos;

}
