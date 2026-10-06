package com.empresa.seguimiento.dto;

import com.empresa.seguimiento.model.Estado;
import java.util.List;

public record HistoriaUsuarioResponse(
        Long id,
        String titulo,
        String descripcion,
        Estado estado,
        int puntosEstimacion,
        int valorNegocio,
        DesarrolladorDTO responsable,
        List<CriterioDTO> criterios) {
}