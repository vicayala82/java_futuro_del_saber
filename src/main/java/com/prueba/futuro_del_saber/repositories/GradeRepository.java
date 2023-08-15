package com.prueba.futuro_del_saber.repositories;

import com.prueba.futuro_del_saber.entities.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<GradeEntity, Long> {
}