package pedidos.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pedidos.modelo.dto.ProductoVentaDto;
import pedidos.modelo.entities.LineasPedido;

public interface LineasPedidoRepository extends JpaRepository<LineasPedido, Integer>{
	@Query("SELECT NEW pedidos.modelo.dto.ProductoVentaDto(lp.producto.idProducto, lp.producto.nombre, SUM(lp.cantidad)) "
            + "FROM LineasPedido lp GROUP BY lp.producto.idProducto, lp.producto.nombre")
			List<ProductoVentaDto> getCantidadTotalVendida();
	

}
