    package com.example.comunidad.model;

    import java.time.LocalDateTime;

    public class Reaccion {
        private int idReaccion;
        private String tipoReaccion;
        private LocalDateTime fechaReaccion;
        private Usuario usuario;
        private Publicacion publicacion;

        public Reaccion(int idReaccion, String tipoReaccion, LocalDateTime fechaReaccion, Publicacion publicacion, Usuario usuario) {
            this.idReaccion = idReaccion;
            this.tipoReaccion = tipoReaccion;
            this.fechaReaccion = fechaReaccion;
            this.publicacion = publicacion;
            this.usuario = usuario;
        }

        public int getIdReaccion() {
            return idReaccion;
        }

        public String getTipoReaccion() {
            return tipoReaccion;
        }

        public LocalDateTime getFechaReaccion() {
            return fechaReaccion;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public Publicacion getPublicacion() {
            return publicacion;
        }

        @Override
        public String toString() {
            return "Reaccion{" +
                    "idReaccion=" + idReaccion +
                    ", tipoReaccion='" + tipoReaccion + '\'' +
                    ", fechaReaccion=" + fechaReaccion +
                    ", usuario=" + usuario +
                    ", publicacion=" + publicacion +
                    '}';
        }
    }
