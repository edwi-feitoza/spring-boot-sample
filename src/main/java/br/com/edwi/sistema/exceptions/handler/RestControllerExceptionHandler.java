package br.com.edwi.sistema.exceptions.handler;

import br.com.edwi.sistema.exceptions.ApiError;
import br.com.edwi.sistema.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {ResourceNotFoundException.class})
    protected ResponseEntity handleResourceNotFound(ResourceNotFoundException e, WebRequest webRequest) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.value(), e.getMessage());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(e, apiError, httpHeaders, HttpStatus.NOT_FOUND, webRequest);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class, DataIntegrityViolationException.class})
    protected ResponseEntity handleUnprocessableEntity(RuntimeException e, WebRequest webRequest) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(), "Payload inválido. Por favor, verfique os dados de entrada.");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(e, apiError, httpHeaders, HttpStatus.BAD_REQUEST, webRequest);
    }

    @ExceptionHandler(value = {RuntimeException.class})
    protected ResponseEntity handleQualquerMerda(RuntimeException e, WebRequest webRequest) {
        e.printStackTrace();
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Fudeu.");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(e, apiError, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR, webRequest);
    }
}