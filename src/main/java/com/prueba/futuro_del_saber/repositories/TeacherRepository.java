package com.prueba.futuro_del_saber.repositories;

import com.prueba.futuro_del_saber.entities.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
}
