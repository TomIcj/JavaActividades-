package com.empresa.seguimiento.dto;

import com.empresa.seguimiento.model.Estado;
import com.empresa.seguimiento.model.Severidad;

public record BugRequest(
        String titulo,
        String descripcion,
        Estado estado,
        String pasosParaReproducir,
        Severidad severidad,
        Long responsableId) {
}