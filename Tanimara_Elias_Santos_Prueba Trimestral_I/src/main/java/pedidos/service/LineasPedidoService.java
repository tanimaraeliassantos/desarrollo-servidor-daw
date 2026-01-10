package pedidos.service;

import java.util.List;

import pedidos.modelo.dto.ProductoVentaDto;
import pedidos.modelo.entities.LineasPedido;

public interface LineasPedidoService {
	List<LineasPedido> buscarTodas();
	List<ProductoVentaDto> getCantidadTotalVendida();

;}
