package com.empresa.seguimiento.dto;

import com.empresa.seguimiento.model.Estado;
import java.util.List;

public record HistoriaUsuarioRequest(
        String titulo,
        String descripcion,
        Estado estado,
        int puntosEstimacion,
        int valorNegocio,
        Long responsableId,
        List<CriterioDTO> criterios) {
}
