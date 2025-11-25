package com.bisa.evaluacion.blog.core.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.bisa.evaluacion.blog.core.dto.ApiError;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ApiError> handleNotFound(NotFoundException ex) {
    ApiError e = new ApiError(HttpStatus.NOT_FOUND.value(), ex.getMessage(),
        List.of(ex.getMessage()));
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
  }

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ApiError> handleBusiness(BusinessException ex) {
    ApiError e = new ApiError(HttpStatus.BAD_REQUEST.value(), ex.getMessage(),
        List.of(ex.getMessage()));
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  protected ResponseEntity<ApiError> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      WebRequest request) {
    List<String> errors = ex.getBindingResult()
        .getFieldErrors()
        .stream()
        .map(FieldError::getDefaultMessage)
        .collect(Collectors.toList());
    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(), "Validación fallida", errors);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ApiError> handleConstraint(ConstraintViolationException ex) {
    List<String> errors = ex.getConstraintViolations().stream()
        .map(ConstraintViolation::getMessage)
        .collect(Collectors.toList());
    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(), "Validación fallida", errors);

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiError> handleAll(Exception ex) {
    ex.printStackTrace();
    ApiError e = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
        "Error inesperado", List.of(ex.getMessage()));
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
  }
}
