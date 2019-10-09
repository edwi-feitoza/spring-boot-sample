package br.com.edwi.sistema.service;

import br.com.edwi.sistema.dtos.ClienteDto;

import java.util.List;

public interface ClienteService {
    List<ClienteDto> buscaTodosClientes();

    ClienteDto buscaCliente(Long id);

    ClienteDto insereCliente(ClienteDto dto);

    ClienteDto alteraCliente(ClienteDto dto);
}