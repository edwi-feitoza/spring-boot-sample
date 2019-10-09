package br.com.edwi.sistema.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ClienteDto {

    private Long id;
    private String nome;
    private String email;
    private String rua;
    private String cidade;
    private String bairro;
    private String cep;
    private String estado;
}