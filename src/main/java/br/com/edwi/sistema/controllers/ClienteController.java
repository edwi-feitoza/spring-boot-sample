package br.com.edwi.sistema.controllers;

import br.com.edwi.sistema.dtos.ClienteDto;
import br.com.edwi.sistema.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("clientes")
@AllArgsConstructor
public class ClienteController {

    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<ClienteDto>> buscaClientes() {
        List<ClienteDto> clientes = this.service.buscaTodosClientes();
        return ResponseEntity.ok().body(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> buscaCliente(@PathVariable("id") Long id) {
        ClienteDto dto = this.service.buscaCliente(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ClienteDto> criaClient(@RequestBody ClienteDto dto){
        ClienteDto result = this.service.insereCliente(dto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> alteraCliente(@PathVariable("id") Long id, @RequestBody ClienteDto dto) {
        dto.setId(id);
        ClienteDto result = this.service.alteraCliente(dto);
        return ResponseEntity.ok().body(result);
    }
}
