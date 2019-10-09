package br.com.edwi.sistema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    public enum STATUS {
        ABERTO,
        CONFIRMADO,
        CANCELADO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "DATAPEDIDO não pode ser nulo ou vazio" )
    private LocalDate dataPedido;

    private String statusPedido;

    @Size(max = 50, message = "SESSAO pode ter no máximo 50 caractéres")
    @NotNull(message = "SESSAO não pode ser nulo ou vazio")
    private String sessao;

    @ManyToOne(optional = false)
    private Cliente cliente;
}
