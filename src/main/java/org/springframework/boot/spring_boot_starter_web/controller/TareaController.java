package org.springframework.boot.spring_boot_starter_web.controller;

import org.springframework.web.bind.annotation.*;   
import org.springframework.http.HttpStatus;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.boot.spring_boot_starter_web.domain.model.Tarea; 
import org.springframework.boot.spring_boot_starter_web.domain.model.EstadoTarea;
import org.springframework.boot.spring_boot_starter_web.service.TareaService;




@RestController
@RequestMapping("/api/tareas")
public class TareaController {
 private final TareaService tareaService;
 public TareaController(TareaService tareaService) {
 this.tareaService = tareaService;
 }
 @GetMapping
 public List<Tarea> listar() {
 return tareaService.listarTodas();
 }
 @GetMapping("/{id}")
 public Tarea buscar(@PathVariable Long id) {
 return tareaService.buscarPorId(id);
 }
 @PostMapping
 @ResponseStatus(HttpStatus.CREATED)
 public Tarea crear(@Valid @RequestBody Tarea tarea) {
 return tareaService.crear(tarea);
 }
 @PatchMapping("/{id}/estado")
 public Tarea cambiarEstado(@PathVariable Long id,
 @RequestParam EstadoTarea estado) {
 return tareaService.cambiarEstado(id, estado);
 }
 @DeleteMapping("/{id}")
 @ResponseStatus(HttpStatus.NO_CONTENT)
 public void eliminar(@PathVariable Long id) {
 tareaService.eliminar(id);
 }
}
