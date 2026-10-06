package com.empresa.seguimiento.repository;

import com.empresa.seguimiento.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
}