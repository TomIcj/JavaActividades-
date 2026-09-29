package com.example.marketing.model;

import java.time.LocalDateTime;

public class Conversion {
    private int idConversion;
    private String tipoConversion;
    private double valor;
    private LocalDateTime fechaConversion;
    private Campana campana;
    private Plataforma plataforma;

    public Conversion(int idConversion, String tipoConversion, double valor, LocalDateTime fechaConversion, Campana campana, Plataforma plataforma) {
        this.idConversion = idConversion;
        this.plataforma = plataforma;
        this.valor = valor;
        this.tipoConversion = tipoConversion;
        this.fechaConversion = fechaConversion;
        this.campana = campana;
    }

    public int getIdConversion() {
        return idConversion;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public Campana getCampana() {
        return campana;
    }

    public LocalDateTime getFechaConversion() {
        return fechaConversion;
    }

    public double getValor() {
        return valor;
    }

    public String getTipoConversion() {
        return tipoConversion;
    }

    @Override
    public String toString() {
        return "Conversion{" +
                "idConversion=" + idConversion +
                ", tipoConversion='" + tipoConversion + '\'' +
                ", valor=" + valor +
                ", fechaConversion=" + fechaConversion +
                ", campana=" + campana +
                ", plataforma=" + plataforma +
                '}';
    }
}
