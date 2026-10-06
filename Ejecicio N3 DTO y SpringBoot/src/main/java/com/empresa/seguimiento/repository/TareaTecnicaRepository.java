package com.empresa.seguimiento.repository;

import com.empresa.seguimiento.model.TareaTecnica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaTecnicaRepository extends JpaRepository<TareaTecnica, Long> {
}