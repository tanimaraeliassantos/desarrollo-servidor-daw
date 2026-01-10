package pedidos.modelo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProductoVentaDto {
	private Long idProducto;
	private String nombreProducto;
	private Long cantidadTotalVendida;
	
	public ProductoVentaDto(Long idProducto, String nombreProducto, Long cantidadTotalVendida) {
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.cantidadTotalVendida = cantidadTotalVendida;
	}
}