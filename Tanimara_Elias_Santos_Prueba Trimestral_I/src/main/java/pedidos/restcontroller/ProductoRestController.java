package pedidos.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pedidos.modelo.entities.Producto;
import pedidos.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoRestController {
	@Autowired
	private ProductoService productoService;
	private List<Producto> lista;
	
	@GetMapping("/todos")
	public List<Producto> todos(){
		return productoService.buscarTodos();
	}
	@GetMapping("/id/{idProducto}")
	public Producto uno(@PathVariable int idProducto) {
		return productoService.buscarUno(idProducto);
	}
	
	@PostMapping("/alta")
	public Producto altaProducto(@RequestBody Producto producto) {
		return productoService.guardar(producto);
	}
	
	@PutMapping("/{idProducto}")
	public Producto modificarProducto(@RequestBody Producto producto, @PathVariable int idProducto) {
		producto.setIdProducto(idProducto);
		Producto productoModificado = productoService.guardar(producto);
		return productoModificado;
	}
	
	@DeleteMapping("/{idProducto}")
	public ResponseEntity<?> eliminar(@PathVariable int idProducto) {
		boolean productoEliminado = productoService.eliminar(idProducto);
		
		if (productoEliminado) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/stock-menor/{stock}")
	public List<Producto> buscarProductosStockMenor(@PathVariable int stock) {
		return productoService.buscarPorStockMenorA(stock);
	}

	@GetMapping("/por-categoria/{idCategoria}")
	public List<Producto> buscarProductosPorCategoria(@PathVariable int idCategoria) {
		return productoService.buscarPorCategoria(idCategoria);
	}
	
	@GetMapping("/por-palabra")
	public ResponseEntity<?> buscarPorPalabra(@RequestParam("palabra") String palabra) {
		List <Producto> productos = productoService.buscarPorPalabra(palabra);
		
		if (productos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(productos, HttpStatus.OK);
	}
}
