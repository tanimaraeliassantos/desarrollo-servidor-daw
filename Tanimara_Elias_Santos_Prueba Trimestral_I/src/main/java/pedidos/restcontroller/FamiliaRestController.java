package pedidos.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pedidos.modelo.entities.Producto;
import pedidos.service.ProductoService;

@RestController
public class FamiliaRestController {
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/{idProducto}")
	public Producto uno(@PathVariable int idProducto) {
		return productoService.buscarUno(idProducto);
	}

}
