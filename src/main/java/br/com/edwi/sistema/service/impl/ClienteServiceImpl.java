package br.com.edwi.sistema.service.impl;

import br.com.edwi.sistema.repository.ClienteRepository;
import br.com.edwi.sistema.dtos.ClienteDto;
import br.com.edwi.sistema.entities.Cliente;
import br.com.edwi.sistema.exceptions.ResourceNotFoundException;
import br.com.edwi.sistema.service.ClienteService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository repository;
    private ModelMapper mapper;


    @Override
    public List<ClienteDto> buscaTodosClientes() {
        List<Cliente> clientes = this.repository.findAll();
        return clientes.stream()
                .map(cliente -> this.convertToDto(cliente))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDto buscaCliente(Long id) {
        Cliente cliente = this.repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return this.convertToDto(cliente);
    }

    @Override
    public ClienteDto insereCliente(ClienteDto dto) {
        Cliente cliente = this.convertToEntity(dto);
        return this.convertToDto(this.repository.save(cliente));
    }

    @Override
    public ClienteDto alteraCliente(ClienteDto dto) {
        Cliente cliente = this.repository.findById(dto.getId()).orElseThrow(ResourceNotFoundException::new);
        cliente = this.convertToEntity(dto);
        return this.convertToDto(this.repository.save(cliente));
    }

    private ClienteDto convertToDto(Cliente cliente) {
        return this.mapper.map(cliente, ClienteDto.class);
    }

    private Cliente convertToEntity(ClienteDto dto) {
        return this.mapper.map(dto, Cliente.class);
    }
}
