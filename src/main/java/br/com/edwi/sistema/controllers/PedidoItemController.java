package br.com.edwi.sistema.controllers;

import br.com.edwi.sistema.service.PedidoItemService;
import br.com.edwi.sistema.dtos.PedidoItemDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("pedido-itens")
@AllArgsConstructor
public class PedidoItemController {

    private PedidoItemService service;

    @GetMapping
    public ResponseEntity<List<PedidoItemDto>> buscaPedidoItens() {
        List<PedidoItemDto> itens = this.service.buscaTodosPedidoItens();
        return ResponseEntity.ok().body(itens);
    }

    @GetMapping("/pedido/{pedidoId}")
    public ResponseEntity<List<PedidoItemDto>> buscaPedidoItensPorPedido(@PathVariable("pedidoId") Long id) {
        List<PedidoItemDto> itens = this.service.buscaPedidoItemPorPedido(id);
        return ResponseEntity.ok().body(itens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoItemDto> buscaPedidoItem(@PathVariable("id") Long id) {
        PedidoItemDto dto = this.service.buscaPedidoItem(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<PedidoItemDto> criaPedidoItem(@RequestBody PedidoItemDto dto){
        PedidoItemDto result = this.service.inserePedidoItem(dto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoItemDto> alteraPedidoitem(@PathVariable("id") Long id, @RequestBody PedidoItemDto dto) {
        dto.setId(id);
        PedidoItemDto result = this.service.alteraPedidoItem(dto);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removePedidoitem(@PathVariable("id") Long id) {
        this.service.removePedidoItem(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}