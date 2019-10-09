package br.com.edwi.sistema.controllers;

import br.com.edwi.sistema.service.PedidoService;
import br.com.edwi.sistema.dtos.PedidoDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.management.relation.RelationServiceNotRegisteredException;
import java.util.List;

@RestController
@RequestMapping("pedidos")
@AllArgsConstructor
public class PedidoController {

    private PedidoService service;

    @GetMapping
    public ResponseEntity<List<PedidoDto>> buscaPedidos() {
        List<PedidoDto> pedidos = this.service.buscaTodosPedidos();
        return ResponseEntity.ok().body(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> buscaPedido(@PathVariable("id") Long id) throws RelationServiceNotRegisteredException {
        PedidoDto dto = this.service.buscaPedido(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<PedidoDto>> buscaPedidosPorCliente(@PathVariable("clienteId") Long id) {
        List<PedidoDto> dto = this.service.buscaPedidosPorCliente(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<PedidoDto> geraPedido(@RequestBody PedidoDto dto){
        PedidoDto result = this.service.geraPedido(dto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/confirma")
    public ResponseEntity<PedidoDto> confirmaPedido(@PathVariable("id") Long id, @RequestBody PedidoDto dto) {
        dto.setId(id);
        PedidoDto result = this.service.confirmaPedido(dto);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/{id}/cancela")
    public ResponseEntity<PedidoDto> cancelaPedido(@PathVariable("id") Long id, @RequestBody PedidoDto dto) {
        dto.setId(id);
        PedidoDto result = this.service.cancelaPedido(dto);
        return ResponseEntity.ok().body(result);
    }
}
