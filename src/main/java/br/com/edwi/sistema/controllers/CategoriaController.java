package br.com.edwi.sistema.controllers;

import br.com.edwi.sistema.dtos.CategoriaDto;
import br.com.edwi.sistema.service.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("categorias")
@AllArgsConstructor
public class CategoriaController {

    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> buscaCategorias() {
        List<CategoriaDto> categorias = this.service.buscaTodasCategorias();
        return ResponseEntity.ok().body(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> buscaCategoria(@PathVariable("id") Long id) {
        CategoriaDto dto = this.service.buscaCategoria(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> criaCategoria(@RequestBody CategoriaDto dto){
        CategoriaDto result = this.service.insereCategoria(dto);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> alteraCategoria(@PathVariable("id") Long id, @RequestBody CategoriaDto dto) {
        dto.setId(id);
        CategoriaDto result = this.service.alteraCategoria(dto);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletaCategoria(@PathVariable("id") Long id) {
        this.service.deletaCategoria(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}