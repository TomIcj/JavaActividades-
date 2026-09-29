package com.example.marketing.runner;

import com.example.marketing.model.Campana;
import com.example.marketing.model.Conversion;
import com.example.marketing.model.Plataforma;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class AcademiaRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Plataforma google = new Plataforma(1, "Google Ads", "https://ads.google.com");
        Campana verano = new Campana(1, "Verano 2026", 5000, LocalDate.of(2026, 1, 15));

        Conversion c1 = new Conversion(1, "venta", 250.0, LocalDateTime.now(), verano, google);

        System.out.println(c1);

        Plataforma meta = new Plataforma(2, "Meta Ads", "https://ads.meta.com");
        Campana invierno = new Campana(2, "Invierno 2026", 8000, LocalDate.of(2026, 6, 1));
        Conversion c2 = new Conversion(2, "registro", 0.0, LocalDateTime.now(), verano, meta);
        Conversion c3 = new Conversion(3, "venta", 400.0, LocalDateTime.now(), invierno, google);
        Conversion c4 = new Conversion(4, "venta", 150.0, LocalDateTime.now(), invierno, meta);

    System.out.println(c2);
    System.out.println(c3);
    System.out.println(c4);
    }
}
