package br.com.edwi.sistema.dtos;

import br.com.edwi.sistema.entities.Cliente;
import lombok.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PedidoDto {
    private Long id;
    private LocalDate dataPedido;
    private String statusPedido;
    private String sessao;
    private Cliente cliente;
}