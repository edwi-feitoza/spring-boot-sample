package br.com.edwi.sistema.repository;

import br.com.edwi.sistema.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {


}
