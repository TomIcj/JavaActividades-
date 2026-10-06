package com.empresa.seguimiento.model;

import jakarta.persistence.*;

@Entity
public class CriterioAceptacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private boolean cumplido;

    public CriterioAceptacion() {}

    public CriterioAceptacion(String descripcion, boolean cumplido) {
        this.descripcion = descripcion;
        this.cumplido = cumplido;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public boolean isCumplido() { return cumplido; }
    public void setCumplido(boolean cumplido) { this.cumplido = cumplido; }
}