package pedidos.service;

import java.util.List;

import pedidos.modelo.entities.Categoria;

public interface CategoriaService {
	List<Categoria> buscarTodos();
	Categoria buscarUno(int idCategoria);
	Categoria guardar(Categoria Categoria);
	boolean eliminar(int idCategoria);
}
