package com.example.comunidad.runner;

import com.example.comunidad.model.Publicacion;
import com.example.comunidad.model.Reaccion;
import com.example.comunidad.model.Usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class AcademiaRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Usuario u1 = new Usuario(1, "ShadowGamer", LocalDate.of(2026, 1, 10));
        Usuario u2 = new Usuario(2, "PixelQueen", LocalDate.of(2026, 3, 5));
        Usuario u3 = new Usuario(3, "NoobMaster", LocalDate.of(2026, 6, 20));

        Publicacion p1 = new Publicacion(1, "¿Alguien para jugar ranked esta noche?", LocalDateTime.now(), u1);
        Publicacion p2 = new Publicacion(2, "¡Terminé el juego al 100%!", LocalDateTime.now(), u2);

        Reaccion r1 = new Reaccion(1, "like", LocalDateTime.now(), p1, u2);
        Reaccion r2 = new Reaccion(2, "corazón", LocalDateTime.now(), p1, u3);
        Reaccion r3 = new Reaccion(3, "risa", LocalDateTime.now(), p2, u1);
        Reaccion r4 = new Reaccion(4, "like", LocalDateTime.now(), p2, u3);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
    }
}