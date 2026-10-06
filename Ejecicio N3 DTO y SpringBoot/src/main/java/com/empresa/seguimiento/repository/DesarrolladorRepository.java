package com.empresa.seguimiento.repository;

import com.empresa.seguimiento.model.Desarrollador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesarrolladorRepository extends JpaRepository<Desarrollador, Long> {
}