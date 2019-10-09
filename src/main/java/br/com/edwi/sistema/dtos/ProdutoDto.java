package br.com.edwi.sistema.dtos;

import lombok.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProdutoDto {
    private Long id;
    private String produto;
    private BigDecimal preco;
    private Short quantidade;
    private String descricao;
    private String foto;
    private CategoriaDto categoria;
}