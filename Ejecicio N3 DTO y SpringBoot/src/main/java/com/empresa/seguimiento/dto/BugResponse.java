package com.empresa.seguimiento.dto;

import com.empresa.seguimiento.model.Estado;
import com.empresa.seguimiento.model.Severidad;

public record BugResponse(
        Long id,
        String titulo,
        String descripcion,
        Estado estado,
        String pasosParaReproducir,
        Severidad severidad,
        DesarrolladorDTO responsable) {
}