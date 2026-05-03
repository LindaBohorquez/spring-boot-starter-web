package org.springframework.boot.spring_boot_starter_web.domain;



public class TareaNotFoundException extends RuntimeException {
 public TareaNotFoundException(String mensaje) {
 super(mensaje);
 }
}