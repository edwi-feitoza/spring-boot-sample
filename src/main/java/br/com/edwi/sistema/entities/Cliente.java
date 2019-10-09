package br.com.edwi.sistema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100, message = "NOME pode ter no máximo 100 caractéres")
    @NotNull(message = "NOME não pode ser nulo ou vazio")
    private String nome;

    @Size(max = 50, message = "EMAIL pode ter no máximo 50 caractéres")
    @NotNull(message = "EMAIL não pode ser nulo ou vazio")
    private String email;

    @Size(max = 100, message = "RUA pode ter no máximo 100 caractéres")
    @NotNull(message = "RUA não pode ser nulo ou vazio")
    private String rua;

    @Size(max = 100, message = "CIDADE pode ter no máximo 100 caractéres")
    @NotNull(message = "CIDADE não pode ser nulo ou vazio")
    private String cidade;

    @Size(max = 100, message = "BAIRRO pode ter no máximo 100 caractéres")
    @NotNull(message = "BAIRRO não pode ser nulo ou vazio")
    private String bairro;

    @Size(max = 8, message = "CEP pode ter no máximo 8 digitos, sem hífen")
    @NotNull(message = "CEP não pode ser nulo ou vazio")
    private String cep;

    @Size(max = 2, message = "ESTADO pode ter no máximo 2 letras")
    @NotNull(message = "ESTADO não pode ser nulo ou vazio")
    private String estado;
}
