package br.com.edwi.sistema.service.impl;

import br.com.edwi.sistema.dtos.ProdutoDto;
import br.com.edwi.sistema.entities.Produto;
import br.com.edwi.sistema.repository.ProdutoRepository;
import br.com.edwi.sistema.service.ProdutoService;
import br.com.edwi.sistema.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository repository;
    private ModelMapper mapper;

    @Override
    public List<ProdutoDto> buscaTodosProdutos() {

        List<Produto> produtos = this.repository.findAll();
        return produtos.stream()
                .map(produto -> this.convertToDto(produto))
                .collect(Collectors.toList());
    }

    @Override
    public ProdutoDto buscaProduto(Long id) {
        Produto produto = this.repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return this.convertToDto(produto);
    }

    @Override
    public ProdutoDto insereProduto(ProdutoDto dto) {
        Produto produto = this.convertToEntity(dto);
        return this.convertToDto(this.repository.save(produto));
    }

    @Override
    public ProdutoDto alteraProduto(ProdutoDto dto) {
        Produto produto = this.repository.findById(dto.getId()).orElseThrow(ResourceNotFoundException::new);
        produto = this.convertToEntity(dto);
        return this.convertToDto(this.repository.save(produto));
    }

    @Override
    public void deletaProduto(Long id) {
        this.repository.deleteById(id);
    }

    private ProdutoDto convertToDto(Produto produto) {
        return this.mapper.map(produto, ProdutoDto.class);
    }

    private Produto convertToEntity(ProdutoDto dto) {
        return this.mapper.map(dto, Produto.class);
    }
}