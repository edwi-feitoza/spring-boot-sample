package br.com.edwi.sistema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100, message = "PRODUTO pode ter no máximo 100 caractéres")
    @NotNull(message = "PRODUTO não pode ser nulo ou vazio")
    private String produto;

    @Positive(message = "PRECO não pode conter valores negativos")
    @NotNull(message = "PRECO não pode ser nulo ou vazio")
    private BigDecimal preco;

    @Positive(message = "QUANTIDADE não pode conter valores negativos")
    @NotNull(message = "QUANTIDADE não pode ser nulo ou vazio")
    private Short quantidade;

    @Size(max = 200, message = "DESCRICAO pode ter no máximo 200 caractéres")
    @NotNull(message = "DESCRICAO não pode ser nulo ou vazio")
    private String descricao;

    @Size(max = 100, message = "FOTO pode ter no máximo 100 caractéres")
    @NotNull(message = "FOTO não pode ser nulo ou vazio")
    private String foto;

    @ManyToOne(optional = false)
    private Categoria categoria;
}