package pedidos.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pedidos.modelo.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
