package com.prueba.futuro_del_saber.repositories;

import com.prueba.futuro_del_saber.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Set;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    @Query("select s from StudentEntity s join fetch s.course c where c.id = :courseId")
    Set<StudentEntity> findByCourseId(Long courseId);
}
