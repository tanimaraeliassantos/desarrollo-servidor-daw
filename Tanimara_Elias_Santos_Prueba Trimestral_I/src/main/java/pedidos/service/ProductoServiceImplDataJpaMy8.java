package pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pedidos.modelo.entities.Producto;
import pedidos.modelo.repository.ProductoRepository;

@Service
public class ProductoServiceImplDataJpaMy8 implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<Producto> buscarTodos() {
		return productoRepository.findAll();
	}
	
	@Override
	public Producto buscarUno(int idProducto) {
		return productoRepository.findById(idProducto).orElse(null);
	}

	@Override
	public Producto guardar(Producto producto) {
		return productoRepository.saveAndFlush(producto);
	}

	@Override
	public boolean eliminar(int idProducto) {
		if(productoRepository.existsById(idProducto)) {
			productoRepository.deleteById(idProducto);
			return true;
		}
		
		return false;
	}

	@Override
	public List<Producto> buscarPorStockMenorA(int stock) {
		return productoRepository.findByStockLessThan(stock);
	}
	
	@Override
	public List<Producto> buscarPorCategoria(int idCategoria) {
		return productoRepository.findByCategoriaIdCategoria(idCategoria);
	}
	
	@Override
	public List<Producto> buscarPorPalabra(String palabra) {
		return productoRepository.findByNombreContaining(palabra);
	}

	
	

}
