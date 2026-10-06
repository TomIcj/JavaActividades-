package com.empresa.seguimiento.controller;

import com.empresa.seguimiento.model.Proyecto;
import com.empresa.seguimiento.repository.DesarrolladorRepository;
import com.empresa.seguimiento.repository.ProyectoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController extends CrudController<Proyecto, Long> {

    private final ProyectoRepository proyectoRepository;
    private final DesarrolladorRepository desarrolladorRepository;

    public ProyectoController(ProyectoRepository proyectoRepository,
                              DesarrolladorRepository desarrolladorRepository) {
        super(proyectoRepository);
        this.proyectoRepository = proyectoRepository;
        this.desarrolladorRepository = desarrolladorRepository;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> actualizar(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        if (!proyectoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        proyecto.setId(id);
        return ResponseEntity.ok(proyectoRepository.save(proyecto));
    }

    @Transactional
    @PostMapping("/{id}/desarrolladores/{devId}")
    public ResponseEntity<Proyecto> agregarDesarrollador(@PathVariable Long id, @PathVariable Long devId) {
        var proyecto = proyectoRepository.findById(id);
        var dev = desarrolladorRepository.findById(devId);
        if (proyecto.isEmpty() || dev.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        proyecto.get().agregarDesarrollador(dev.get());
        return ResponseEntity.ok(proyectoRepository.save(proyecto.get()));
    }

    @Transactional
    @DeleteMapping("/{id}/desarrolladores/{devId}")
    public ResponseEntity<Proyecto> quitarDesarrollador(@PathVariable Long id, @PathVariable Long devId) {
        var proyecto = proyectoRepository.findById(id);
        if (proyecto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        proyecto.get().getDesarrolladores().removeIf(d -> d.getId().equals(devId));
        return ResponseEntity.ok(proyectoRepository.save(proyecto.get()));
    }
}