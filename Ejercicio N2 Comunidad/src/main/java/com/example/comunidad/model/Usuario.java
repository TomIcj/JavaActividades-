package com.example.comunidad.model;

import java.time.LocalDate;

public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private LocalDate fechaRegistro;

    public Usuario(int idUsuario, String nombreUsuario, LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
