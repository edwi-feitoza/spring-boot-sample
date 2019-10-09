package br.com.edwi.sistema.repository;

import br.com.edwi.sistema.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT p FROM Pedido p WHERE p.cliente.id = ?1")
    List<Pedido> findByCliente(Long clienteId);

    @Query("SELECT p.statusPedido FROM Pedido p WHERE p.id = ?1")
    String findStatusPedidoById(Long id);
}