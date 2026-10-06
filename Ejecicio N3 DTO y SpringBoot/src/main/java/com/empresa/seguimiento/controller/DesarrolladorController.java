package com.empresa.seguimiento.controller;

import com.empresa.seguimiento.model.Desarrollador;
import com.empresa.seguimiento.repository.DesarrolladorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/desarrolladores")
public class DesarrolladorController extends CrudController<Desarrollador, Long> {

    public DesarrolladorController(DesarrolladorRepository repository) {
        super(repository);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Desarrollador> actualizar(@PathVariable Long id, @RequestBody Desarrollador desarrollador) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        desarrollador.setId(id);
        return ResponseEntity.ok(repository.save(desarrollador));
    }
}