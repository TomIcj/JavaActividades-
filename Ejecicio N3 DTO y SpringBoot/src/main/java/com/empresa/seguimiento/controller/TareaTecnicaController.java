package com.empresa.seguimiento.controller;

import com.empresa.seguimiento.model.TareaTecnica;
import com.empresa.seguimiento.repository.TareaTecnicaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tareas-tecnicas")
public class TareaTecnicaController extends CrudController<TareaTecnica, Long> {

    public TareaTecnicaController(TareaTecnicaRepository repository) {
        super(repository);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TareaTecnica> actualizar(@PathVariable Long id, @RequestBody TareaTecnica tarea) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tarea.setId(id);
        return ResponseEntity.ok(repository.save(tarea));
    }
}