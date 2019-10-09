package br.com.edwi.sistema.service.impl;

import br.com.edwi.sistema.entities.Pedido;
import br.com.edwi.sistema.repository.PedidoRepository;
import br.com.edwi.sistema.service.PedidoService;
import br.com.edwi.sistema.dtos.PedidoDto;
import br.com.edwi.sistema.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import javax.management.relation.RelationServiceNotRegisteredException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private PedidoRepository repository;
    private ModelMapper mapper;

    @Override
    public List<PedidoDto> buscaTodosPedidos() {
        List<Pedido> pedidos = this.repository.findAll();
        return pedidos.stream()
                .map(pedido -> this.convertToDto(pedido))
                .collect(Collectors.toList());
    }

    @Override
    public PedidoDto buscaPedido(Long id) throws RelationServiceNotRegisteredException {
        Pedido pedido = this.repository.findById(id).orElseThrow(RelationServiceNotRegisteredException::new);
        return this.convertToDto(pedido);
    }

    @Override
    public List<PedidoDto> buscaPedidosPorCliente(Long id) {
        List<Pedido> pedidos = this.repository.findByCliente(id);
        return pedidos.stream()
                .map(pedido -> this.convertToDto(pedido))
                .collect(Collectors.toList());
    }

    @Override
    public PedidoDto geraPedido(PedidoDto dto) {
        Pedido pedido = this.convertToEntity(dto);
        pedido.setStatusPedido(Pedido.STATUS.ABERTO.toString());
        return this.convertToDto(this.repository.save(pedido));
    }

    @Override
    public PedidoDto confirmaPedido(PedidoDto dto) {
        Pedido pedido = this.repository.findById(dto.getId()).orElseThrow(ResourceNotFoundException::new);
        pedido.setStatusPedido(Pedido.STATUS.CONFIRMADO.toString());
        return this.convertToDto(this.repository.save(pedido));
    }

    @Override
    public PedidoDto cancelaPedido(PedidoDto dto) {
        Pedido pedido = this.repository.findById(dto.getId()).orElseThrow(ResourceNotFoundException::new);
        pedido.setStatusPedido(Pedido.STATUS.CANCELADO.toString());
        return this.convertToDto(this.repository.save(pedido));
    }

    @Override
    public Boolean verificaSePedidoEstaAberto(Long id) {
        String result = this.repository.findStatusPedidoById(id);
        Pedido.STATUS status = Pedido.STATUS.valueOf(result);
        return status.equals(Pedido.STATUS.ABERTO);
    }

    private PedidoDto convertToDto(Pedido pedido) {
        return this.mapper.map(pedido, PedidoDto.class);
    }

    private Pedido convertToEntity(PedidoDto dto) {
        return this.mapper.map(dto, Pedido.class);
    }
}