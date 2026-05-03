package org.springframework.boot.spring_boot_starter_web.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.spring_boot_starter_web.domain.TareaNotFoundException;



@RestControllerAdvice
public class GlobalExceptionHandler {
 @ExceptionHandler(TareaNotFoundException.class)
 @ResponseStatus(HttpStatus.NOT_FOUND)
 public Map<String, String> handleNotFound(TareaNotFoundException ex)
{
 return Map.of("error", ex.getMessage());
 }
 @ExceptionHandler(MethodArgumentNotValidException.class)
 @ResponseStatus(HttpStatus.BAD_REQUEST)
 public Map<String, String>
handleValidation(MethodArgumentNotValidException ex) {
 Map<String, String> errores = new HashMap<>();
 ex.getBindingResult().getFieldErrors()
 .forEach(e -> errores.put(e.getField(),
e.getDefaultMessage()));
 return errores;
    }
}
