package pedidos.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pedidos.modelo.entities.LineasPedido;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LineaPedidoDto {
	
	private int numeroOrden;
	private int idPedido;
	private long idProducto;
	private int cantidad;
	private double precioUnitario;
	
	public static LineaPedidoDto convertALineaPedidoDto(LineasPedido linea) {
		LineaPedidoDto lineaP = new LineaPedidoDto();
        lineaP.setCantidad(linea.getCantidad());
        lineaP.setIdPedido(linea.getPedido().getIdPedido());
        lineaP.setIdProducto(linea.getProducto().getIdProducto());
        lineaP.setNumeroOrden(linea.getNumeroOrden());
        lineaP.setPrecioUnitario(linea.getPrecioUnitario());
		return lineaP;
	}
	
	

}
