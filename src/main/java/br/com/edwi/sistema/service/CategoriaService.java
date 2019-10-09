package br.com.edwi.sistema.service;

import br.com.edwi.sistema.dtos.CategoriaDto;

import java.util.List;

public interface CategoriaService {

    List<CategoriaDto> buscaTodasCategorias();

    CategoriaDto buscaCategoria(Long id);

    CategoriaDto insereCategoria(CategoriaDto categoria);

    CategoriaDto alteraCategoria (CategoriaDto categoria);

    void deletaCategoria(Long id);
}