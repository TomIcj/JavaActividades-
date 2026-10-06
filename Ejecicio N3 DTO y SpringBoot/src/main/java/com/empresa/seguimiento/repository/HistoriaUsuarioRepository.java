package com.empresa.seguimiento.repository;

import com.empresa.seguimiento.model.HistoriaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoriaUsuarioRepository extends JpaRepository<HistoriaUsuario, Long> {
}