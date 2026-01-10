package pedidos.service;

import java.util.List;

import pedidos.modelo.entities.Producto;

public interface ProductoService {
	List<Producto> buscarTodos();
	Producto buscarUno(int idProducto);
	Producto guardar(Producto producto);
	boolean eliminar(int idProducto);
	
	List<Producto> buscarPorStockMenorA(int stock);
	List<Producto> buscarPorCategoria(int idCategoria);

	List<Producto> buscarPorPalabra(String palabra);
}
