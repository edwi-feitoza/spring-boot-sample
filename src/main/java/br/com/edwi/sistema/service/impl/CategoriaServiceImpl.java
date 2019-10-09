package br.com.edwi.sistema.service.impl;

import br.com.edwi.sistema.dtos.CategoriaDto;
import br.com.edwi.sistema.entities.Categoria;
import br.com.edwi.sistema.exceptions.ResourceNotFoundException;
import br.com.edwi.sistema.repository.CategoriaRepository;
import br.com.edwi.sistema.service.CategoriaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private CategoriaRepository repository;
    private ModelMapper mapper;

    @Override
    public List<CategoriaDto> buscaTodasCategorias() {

        List<Categoria> categorias = this.repository.findAll();
        return categorias.stream()
                .map(c -> this.convertToDto(c))
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDto buscaCategoria(Long id) {
        Categoria categoria = this.repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return this.convertToDto(categoria);
    }

    @Override
    public CategoriaDto insereCategoria(CategoriaDto dto) {
        Categoria categoria = this.convertToEntity(dto);
        return this.convertToDto(this.repository.save(categoria));
    }

    @Override
    public CategoriaDto alteraCategoria(CategoriaDto dto) {
        Categoria categoria = this.repository.findById(dto.getId()).orElseThrow(ResourceNotFoundException::new);
        categoria = this.convertToEntity(dto);
        return this.convertToDto(repository.save(categoria));
    }

    @Override
    public void deletaCategoria(Long id) {
        this.repository.deleteById(id);
    }

    private CategoriaDto convertToDto(Categoria categoria) {
        return this.mapper.map(categoria, CategoriaDto.class);
    }

    private Categoria convertToEntity(CategoriaDto dto) {
        return this.mapper.map(dto, Categoria.class);
    }
}