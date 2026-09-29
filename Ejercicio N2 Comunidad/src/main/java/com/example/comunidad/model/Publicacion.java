package com.example.comunidad.model;

import java.time.LocalDateTime;

public class Publicacion {
    private int idPublicacion;
    private String contenido;
    private LocalDateTime fechaPublicacion;
    private Usuario autor;

    public Publicacion(int idPublicacion, String contenido, LocalDateTime fechaPublicacion, Usuario autor) {        this.idPublicacion = idPublicacion;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public Usuario getAutor() {
        return autor;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }

    @Override
    public String toString() {
        return "Publicacion{" +
                "idPublicacion=" + idPublicacion +
                ", contenido='" + contenido + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                ", autor=" + autor +
                '}';
    }
}
