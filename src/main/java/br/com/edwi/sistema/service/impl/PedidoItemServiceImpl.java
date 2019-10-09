package br.com.edwi.sistema.service.impl;

import br.com.edwi.sistema.entities.PedidoItem;
import br.com.edwi.sistema.dtos.PedidoItemDto;
import br.com.edwi.sistema.exceptions.ResourceNotFoundException;
import br.com.edwi.sistema.exceptions.UnprocessableEntityException;
import br.com.edwi.sistema.repository.PedidoItemRepository;
import br.com.edwi.sistema.service.PedidoItemService;
import br.com.edwi.sistema.service.PedidoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PedidoItemServiceImpl implements PedidoItemService {

    private PedidoService pedidoService;
    private PedidoItemRepository repository;
    private ModelMapper mapper;

    @Override
    public List<PedidoItemDto> buscaTodosPedidoItens() {
        List<PedidoItem> items = this.repository.findAll();
        return items.stream()
                .map(item -> this.convertToDto(item))
                .collect(Collectors.toList());
    }

    @Override
    public List<PedidoItemDto> buscaPedidoItemPorPedido(Long pedidoId) {
        List<PedidoItem> items = this.repository.findAllByPedidoId(pedidoId);
        return items.stream()
                .map(item -> this.convertToDto(item))
                .collect(Collectors.toList());
    }

    @Override
    public PedidoItemDto buscaPedidoItem(Long id) {
        PedidoItem item = this.repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return this.convertToDto(item);
    }

    @Override
    public PedidoItemDto inserePedidoItem(PedidoItemDto dto) {
        this.verificaSePedidoEstaAberto(dto.getPedido().getId());
        PedidoItem item = this.convertToEntity(dto);
        item.setValor(dto.getProduto().getPreco());
        item.setSubtotal(item.getValor().multiply(new BigDecimal(dto.getQuantidade().toString())));
        return this.convertToDto(this.repository.save(item));
    }

    @Override
    public PedidoItemDto alteraPedidoItem(PedidoItemDto dto) {
        this.verificaSePedidoEstaAberto(dto.getPedido().getId());
        PedidoItem item = this.repository.findById(dto.getId()).orElseThrow(ResourceNotFoundException::new);
        item = this.convertToEntity(dto);
        item.setValor(dto.getProduto().getPreco());
        item.setSubtotal(item.getValor().multiply(new BigDecimal(dto.getQuantidade().toString())));
        return this.convertToDto(this.repository.save(item));
    }

    @Override
    public void removePedidoItem(Long id) {
        PedidoItem item = this.repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        this.verificaSePedidoEstaAberto(item.getPedido().getId());
        this.repository.deleteById(id);
    }

    private void verificaSePedidoEstaAberto(Long pedidoId) {
        Boolean pedidoAberto = this.pedidoService.verificaSePedidoEstaAberto(pedidoId);
        if(!pedidoAberto) throw new UnprocessableEntityException("Pedido não está aberto! Não é possível modifica-lo!");
    }

    private PedidoItemDto convertToDto(PedidoItem item) {
        return this.mapper.map(item, PedidoItemDto.class);
    }

    private PedidoItem convertToEntity(PedidoItemDto dto) {
        return this.mapper.map(dto, PedidoItem.class);
    }
}