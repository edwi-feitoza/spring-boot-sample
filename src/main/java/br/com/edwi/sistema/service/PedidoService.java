package br.com.edwi.sistema.service;

import br.com.edwi.sistema.dtos.PedidoDto;

import javax.management.relation.RelationServiceNotRegisteredException;
import java.util.List;

public interface PedidoService {
    List<PedidoDto> buscaTodosPedidos();

    PedidoDto buscaPedido(Long id) throws RelationServiceNotRegisteredException;

    List<PedidoDto> buscaPedidosPorCliente(Long id);

    PedidoDto geraPedido(PedidoDto dto);

    PedidoDto confirmaPedido(PedidoDto dto);

    PedidoDto cancelaPedido(PedidoDto dto);

    Boolean verificaSePedidoEstaAberto(Long id);
}