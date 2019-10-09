package br.com.edwi.sistema.repository;

import br.com.edwi.sistema.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
