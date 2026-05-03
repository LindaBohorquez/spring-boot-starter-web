package org.springframework.boot.spring_boot_starter_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.boot.spring_boot_starter_web.domain.model.Tarea;
import org.springframework.boot.spring_boot_starter_web.domain.model.EstadoTarea;


@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
 List<Tarea> findByEstado(EstadoTarea estado);
 List<Tarea> findByTituloContainingIgnoreCase(String titulo);
}
