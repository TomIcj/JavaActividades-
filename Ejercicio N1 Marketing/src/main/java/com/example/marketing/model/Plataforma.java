package com.example.marketing.model;

public class Plataforma {
    private int idPlataforma;
    private String nombrePlataforma;
    private String urlPlataforma;

    public Plataforma(int idPlataforma, String nombrePlataforma, String urlPlataforma)  {
        this.idPlataforma = idPlataforma;
        this.urlPlataforma = urlPlataforma;
        this.nombrePlataforma = nombrePlataforma;
    }

    public int getIdPlataforma() {
        return idPlataforma;
    }

    public String getNombrePlataforma() {
        return nombrePlataforma;
    }

    public String getUrlPlataforma() {
        return urlPlataforma;
    }

    @Override
    public String toString() {
        return "Plataforma{" +
                "idPlataforma=" + idPlataforma +
                ", nombrePlataforma='" + nombrePlataforma + '\'' +
                ", urlPlataforma='" + urlPlataforma + '\'' +
                '}';
    }
}
