package com.empresa.seguimiento.controller;

import com.empresa.seguimiento.dto.CriterioDTO;
import com.empresa.seguimiento.dto.DesarrolladorDTO;
import com.empresa.seguimiento.dto.HistoriaUsuarioRequest;
import com.empresa.seguimiento.dto.HistoriaUsuarioResponse;
import com.empresa.seguimiento.model.CriterioAceptacion;
import com.empresa.seguimiento.model.Desarrollador;
import com.empresa.seguimiento.model.HistoriaUsuario;
import com.empresa.seguimiento.repository.DesarrolladorRepository;
import com.empresa.seguimiento.repository.HistoriaUsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/historias")
public class HistoriaUsuarioController {

    private final HistoriaUsuarioRepository historiaRepository;
    private final DesarrolladorRepository desarrolladorRepository;

    public HistoriaUsuarioController(HistoriaUsuarioRepository historiaRepository,
                                     DesarrolladorRepository desarrolladorRepository) {
        this.historiaRepository = historiaRepository;
        this.desarrolladorRepository = desarrolladorRepository;
    }

    @GetMapping
    public List<HistoriaUsuarioResponse> listar() {
        return historiaRepository.findAll().stream().map(this::aResponse).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriaUsuarioResponse> obtener(@PathVariable Long id) {
        return historiaRepository.findById(id)
                .map(h -> ResponseEntity.ok(aResponse(h)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HistoriaUsuarioResponse> crear(@RequestBody HistoriaUsuarioRequest request) {
        HistoriaUsuario historia = new HistoriaUsuario();
        if (!copiarDatos(historia, request)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(aResponse(historiaRepository.save(historia)));
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<HistoriaUsuarioResponse> actualizar(@PathVariable Long id,
                                                              @RequestBody HistoriaUsuarioRequest request) {
        var existente = historiaRepository.findById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        HistoriaUsuario historia = existente.get();
        if (!copiarDatos(historia, request)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(aResponse(historiaRepository.save(historia)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!historiaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        historiaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // DTO -> entidad. Devuelve false si el responsable no existe.
    private boolean copiarDatos(HistoriaUsuario historia, HistoriaUsuarioRequest request) {
        Desarrollador responsable = null;
        if (request.responsableId() != null) {
            responsable = desarrolladorRepository.findById(request.responsableId()).orElse(null);
            if (responsable == null) {
                return false;
            }
        }
        historia.setTitulo(request.titulo());
        historia.setDescripcion(request.descripcion());
        historia.setEstado(request.estado());
        historia.setPuntosEstimacion(request.puntosEstimacion());
        historia.setValorNegocio(request.valorNegocio());
        historia.setResponsable(responsable);

        // Se reemplaza el contenido de la misma lista (necesario por orphanRemoval)
        historia.getCriteriosAceptacion().clear();
        if (request.criterios() != null) {
            for (CriterioDTO c : request.criterios()) {
                historia.agregarCriterio(new CriterioAceptacion(c.descripcion(), c.cumplido()));
            }
        }
        return true;
    }

    // entidad -> DTO
    private HistoriaUsuarioResponse aResponse(HistoriaUsuario h) {
        Desarrollador r = h.getResponsable();
        DesarrolladorDTO responsable = (r == null) ? null
                : new DesarrolladorDTO(r.getId(), r.getNombre(), r.getEspecialidad(), r.getMail());

        List<CriterioDTO> criterios = new ArrayList<>();
        for (CriterioAceptacion c : h.getCriteriosAceptacion()) {
            criterios.add(new CriterioDTO(c.getId(), c.getDescripcion(), c.isCumplido()));
        }

        return new HistoriaUsuarioResponse(h.getId(), h.getTitulo(), h.getDescripcion(), h.getEstado(),
                h.getPuntosEstimacion(), h.getValorNegocio(), responsable, criterios);
    }
}