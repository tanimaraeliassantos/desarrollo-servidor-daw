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
import org.springframework.web.bind.annotation.RestController;

import pedidos.modelo.entities.Categoria;
import pedidos.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaRestController {
	@Autowired
	private CategoriaService categoriaService;
	private List<Categoria> lista;
	
	@GetMapping("/todas")
	public List<Categoria> todos() {
		return categoriaService.buscarTodos();
		}
	
	@GetMapping("/id/{idCategoria}")
	public Categoria una(@PathVariable int idCategoria) {
		return categoriaService.buscarUno(idCategoria);
	}
	
	@PostMapping("/alta")
	public Categoria altaCategoria(@RequestBody Categoria categoria) {
		return categoriaService.guardar(categoria);
	}
	
	@PutMapping("/{idCategoria}")
	public Categoria modificarCategoria(@RequestBody Categoria categoria, @PathVariable int idCategoria) {
		categoria.setIdCategoria(idCategoria);
		Categoria categoriaModificada = categoriaService.guardar(categoria);
		return categoriaModificada;
	}
	
	@DeleteMapping("/{idCategoria}")
	public ResponseEntity<?> eliminar(@PathVariable int idCategoria) {
		boolean categoriaEliminado = categoriaService.eliminar(idCategoria);
		
		if (categoriaEliminado) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
