package br.com.edwi.sistema.service;

import br.com.edwi.sistema.dtos.PedidoItemDto;
import java.util.List;

public interface PedidoItemService {
    List<PedidoItemDto> buscaTodosPedidoItens();

    PedidoItemDto buscaPedidoItem(Long id);

    PedidoItemDto inserePedidoItem(PedidoItemDto dto);

    PedidoItemDto alteraPedidoItem(PedidoItemDto dto);

    List<PedidoItemDto> buscaPedidoItemPorPedido(Long pedidoId);

    void removePedidoItem(Long id);
}