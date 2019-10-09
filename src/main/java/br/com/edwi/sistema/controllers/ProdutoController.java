package br.com.edwi.sistema.controllers;

import br.com.edwi.sistema.dtos.ProdutoDto;
import br.com.edwi.sistema.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("produtos")
@AllArgsConstructor
public class ProdutoController {

    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> buscaProdutos() {
        List<ProdutoDto> produtos = this.service.buscaTodosProdutos();
        return ResponseEntity.ok().body(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> buscaProduto(@PathVariable("id") Long id) {
        ProdutoDto dto = this.service.buscaProduto(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ProdutoDto> criaProduto(@RequestBody ProdutoDto dto){
        ProdutoDto result = this.service.insereProduto(dto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDto> alteraProduto(@PathVariable("id") Long id, @RequestBody ProdutoDto dto) {
        dto.setId(id);
        ProdutoDto result = this.service.alteraProduto(dto);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletaProduto(@PathVariable("id") Long id) {
        this.service.deletaProduto(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}