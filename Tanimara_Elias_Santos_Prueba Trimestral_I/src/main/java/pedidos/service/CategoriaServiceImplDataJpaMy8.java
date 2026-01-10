package pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pedidos.modelo.entities.Categoria;
import pedidos.modelo.repository.CategoriaRepository;

@Service
public class CategoriaServiceImplDataJpaMy8 implements CategoriaService{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> buscarTodos() {
		return categoriaRepository.findAll();
	}

	@Override
	public Categoria buscarUno(int idCategoria) {
		return categoriaRepository.findById(idCategoria).orElse(null);
	}

	@Override
	public Categoria guardar(Categoria Categoria) {
		return categoriaRepository.saveAndFlush(Categoria);
	}

	@Override
	public boolean eliminar(int idCategoria) {
		if(categoriaRepository.existsById(idCategoria)) {
			categoriaRepository.deleteById(idCategoria);
			return true;
		}
		
		return false;
	}

}
