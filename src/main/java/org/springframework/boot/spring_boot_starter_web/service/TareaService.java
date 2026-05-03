package org.springframework.boot.spring_boot_starter_web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;    
import java.util.List;
import org.springframework.boot.spring_boot_starter_web.domain.model.Tarea;
import org.springframework.boot.spring_boot_starter_web.domain.model.EstadoTarea;
import org.springframework.boot.spring_boot_starter_web.repository.TareaRepository;
import org.springframework.boot.spring_boot_starter_web.domain.TareaNotFoundException;




@Service
@Transactional
public class TareaService {
 private final TareaRepository tareaRepository;
 public TareaService(TareaRepository tareaRepository) {
 this.tareaRepository = tareaRepository;
 }
 public List<Tarea> listarTodas() {
 return tareaRepository.findAll();
 }
 public Tarea buscarPorId(Long id) {
 return tareaRepository.findById(id).orElseThrow(() -> new TareaNotFoundException("Tarea " + id + " no encontrada"));
 }
 public Tarea crear(Tarea tarea) {
 tarea.setEstado(EstadoTarea.PENDIENTE);
 return tareaRepository.save(tarea);
 }
 public Tarea cambiarEstado(Long id, EstadoTarea nuevoEstado) {
 Tarea tarea = buscarPorId(id);
 tarea.setEstado(nuevoEstado);
 return tareaRepository.save(tarea);
 }
 public void eliminar(Long id) {
 buscarPorId(id); // valida existencia
 tareaRepository.deleteById(id);
 }
}