package com.empresa.seguimiento.controller;

import com.empresa.seguimiento.dto.BugRequest;
import com.empresa.seguimiento.dto.BugResponse;
import com.empresa.seguimiento.dto.DesarrolladorDTO;
import com.empresa.seguimiento.model.Bug;
import com.empresa.seguimiento.model.Desarrollador;
import com.empresa.seguimiento.repository.BugRepository;
import com.empresa.seguimiento.repository.DesarrolladorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bugs")
public class BugController {

    private final BugRepository bugRepository;
    private final DesarrolladorRepository desarrolladorRepository;

    public BugController(BugRepository bugRepository, DesarrolladorRepository desarrolladorRepository) {
        this.bugRepository = bugRepository;
        this.desarrolladorRepository = desarrolladorRepository;
    }

    @GetMapping
    public List<BugResponse> listar() {
        return bugRepository.findAll().stream().map(this::aResponse).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BugResponse> obtener(@PathVariable Long id) {
        return bugRepository.findById(id)
                .map(b -> ResponseEntity.ok(aResponse(b)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BugResponse> crear(@RequestBody BugRequest request) {
        Bug bug = new Bug();
        if (!copiarDatos(bug, request)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(aResponse(bugRepository.save(bug)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BugResponse> actualizar(@PathVariable Long id, @RequestBody BugRequest request) {
        var existente = bugRepository.findById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Bug bug = existente.get();
        if (!copiarDatos(bug, request)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(aResponse(bugRepository.save(bug)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!bugRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        bugRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // DTO -> entidad. Devuelve false si el responsable no existe.
    private boolean copiarDatos(Bug bug, BugRequest request) {
        Desarrollador responsable = null;
        if (request.responsableId() != null) {
            responsable = desarrolladorRepository.findById(request.responsableId()).orElse(null);
            if (responsable == null) {
                return false;
            }
        }
        bug.setTitulo(request.titulo());
        bug.setDescripcion(request.descripcion());
        bug.setEstado(request.estado());
        bug.setPasosParaReproducir(request.pasosParaReproducir());
        bug.setSeveridad(request.severidad());
        bug.setResponsable(responsable);
        return true;
    }

    // entidad -> DTO
    private BugResponse aResponse(Bug b) {
        Desarrollador r = b.getResponsable();
        DesarrolladorDTO responsable = (r == null) ? null
                : new DesarrolladorDTO(r.getId(), r.getNombre(), r.getEspecialidad(), r.getMail());
        return new BugResponse(b.getId(), b.getTitulo(), b.getDescripcion(), b.getEstado(),
                b.getPasosParaReproducir(), b.getSeveridad(), responsable);
    }
}