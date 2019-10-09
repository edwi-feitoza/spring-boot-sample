package br.com.edwi.sistema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive(message = "QUANTIDADE não pode conter valores negativos")
    @NotNull(message = "QUANTIDADE não pode ser nulo ou vazio")
    private Short quantidade;

    @Positive(message = "VALOR não pode conter valores negativos")
    @NotNull(message = "VALOR não pode ser nulo ou vazio")
    private BigDecimal valor;

    @Positive(message = "SUBTOTAL não pode conter valores negativos")
    @NotNull(message = "SUBTOTAL não pode ser nulo ou vazio")
    private BigDecimal subtotal;

    @ManyToOne(optional = false)
    private Pedido pedido;

    @ManyToOne(optional = false)
    private Produto produto;
}