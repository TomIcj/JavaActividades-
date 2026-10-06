package com.empresa.seguimiento.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HistoriaUsuario extends Trabajo {

    private int puntosEstimacion;
    private int valorNegocio;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "historia_id", nullable = false)
    private List<CriterioAceptacion> criteriosAceptacion = new ArrayList<>();

    public int getPuntosEstimacion() { return puntosEstimacion; }
    public void setPuntosEstimacion(int puntosEstimacion) { this.puntosEstimacion = puntosEstimacion; }
    public int getValorNegocio() { return valorNegocio; }
    public void setValorNegocio(int valorNegocio) { this.valorNegocio = valorNegocio; }
    public List<CriterioAceptacion> getCriteriosAceptacion() { return criteriosAceptacion; }
    public void setCriteriosAceptacion(List<CriterioAceptacion> criteriosAceptacion) { this.criteriosAceptacion = criteriosAceptacion; }

    public void agregarCriterio(CriterioAceptacion criterio) { criteriosAceptacion.add(criterio); }
}