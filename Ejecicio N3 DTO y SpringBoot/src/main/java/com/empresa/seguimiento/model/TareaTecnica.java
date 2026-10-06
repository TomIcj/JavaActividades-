package com.empresa.seguimiento.model;

import jakarta.persistence.*;

@Entity
public class TareaTecnica extends Trabajo {

    private String componenteAfectado;

    public String getComponenteAfectado() { return componenteAfectado; }
    public void setComponenteAfectado(String componenteAfectado) { this.componenteAfectado = componenteAfectado; }
}