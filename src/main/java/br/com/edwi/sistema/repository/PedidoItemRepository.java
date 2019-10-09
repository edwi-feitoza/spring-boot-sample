package br.com.edwi.sistema.repository;

import br.com.edwi.sistema.entities.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {

    @Query("SELECT p FROM PedidoItem p WHERE p.pedido.id = ?1")
    List<PedidoItem> findAllByPedidoId(Long id);
}