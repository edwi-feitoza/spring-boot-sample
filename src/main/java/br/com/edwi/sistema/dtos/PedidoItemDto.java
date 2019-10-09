package br.com.edwi.sistema.dtos;

import br.com.edwi.sistema.entities.Pedido;
import br.com.edwi.sistema.entities.Produto;
import lombok.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PedidoItemDto {
    private Long id;
    private Short quantidade;
    private BigDecimal valor;
    private BigDecimal subtotal;
    private Pedido pedido;
    private Produto produto;
}
