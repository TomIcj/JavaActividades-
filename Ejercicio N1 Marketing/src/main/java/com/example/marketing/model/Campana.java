package com.example.marketing.model;

import java.time.LocalDate;

public class Campana {

    private int idCampana;
    private String nombreCampana;
    private double presupuesto;
    private LocalDate fechaInicio;

    public Campana(int idCampana, String nombreCampana, double presupuesto, LocalDate fechaInicio) {
        this.idCampana = idCampana;
        this.nombreCampana = nombreCampana;
        this.presupuesto = presupuesto;
        this.fechaInicio = fechaInicio;
    }

    public int getIdCampana() {
        return idCampana;
    }

    public String getNombreCampana() {
        return nombreCampana;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    @Override
    public String toString() {
        return "Campana{" +
                "idCampana=" + idCampana +
                ", nombreCampana='" + nombreCampana + '\'' +
                ", presupuesto=" + presupuesto +
                ", fechaInicio=" + fechaInicio +
                '}';
    }
}