package com.prueba.futuro_del_saber.repositories;

import com.prueba.futuro_del_saber.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

    CourseEntity findByLevelCourse(String courseName);
}