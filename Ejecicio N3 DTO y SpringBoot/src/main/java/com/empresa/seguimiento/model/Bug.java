package com.empresa.seguimiento.model;

import jakarta.persistence.*;

@Entity
public class Bug extends Trabajo {

    @Column(length = 1000)
    private String pasosParaReproducir;

    @Enumerated(EnumType.STRING)
    private Severidad severidad;

    public String getPasosParaReproducir() { return pasosParaReproducir; }
    public void setPasosParaReproducir(String pasosParaReproducir) { this.pasosParaReproducir = pasosParaReproducir; }
    public Severidad getSeveridad() { return severidad; }
    public void setSeveridad(Severidad severidad) { this.severidad = severidad; }
}