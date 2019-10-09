package br.com.edwi.sistema.repository;

import br.com.edwi.sistema.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
