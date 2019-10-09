package br.com.edwi.sistema.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CategoriaDto {

    private Long id;
    private String categoria;
}