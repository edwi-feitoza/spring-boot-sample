package br.com.edwi.sistema.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiError {
    private Integer code;
    private String message;
}