package com.empresa.seguimiento.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class CrudController<T, ID> {

    protected final JpaRepository<T, ID> repository;

    protected CrudController(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<T> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> obtener(@PathVariable ID id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public T crear(@RequestBody T entidad) {
        return repository.save(entidad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable ID id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}