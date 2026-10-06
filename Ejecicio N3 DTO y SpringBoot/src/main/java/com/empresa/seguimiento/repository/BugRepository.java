package com.empresa.seguimiento.repository;

import com.empresa.seguimiento.model.Bug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BugRepository extends JpaRepository<Bug, Long> {
}