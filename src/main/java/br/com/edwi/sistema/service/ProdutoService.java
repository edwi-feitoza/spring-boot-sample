package br.com.edwi.sistema.service;

import br.com.edwi.sistema.dtos.ProdutoDto;

import java.util.List;

public interface ProdutoService {
    List<ProdutoDto> buscaTodosProdutos();

    ProdutoDto buscaProduto(Long id);

    ProdutoDto insereProduto(ProdutoDto dto);

    ProdutoDto alteraProduto(ProdutoDto dto);

    void deletaProduto(Long id);
}