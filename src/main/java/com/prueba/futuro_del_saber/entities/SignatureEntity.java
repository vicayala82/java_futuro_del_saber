package com.prueba.futuro_del_saber.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.Set;

@Getter
@Entity
@Table(name = "signature")
public class SignatureEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "TEACHER_ID")
    private TeacherEntity teacher;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "signatures"
    )
    private Set<StudentEntity> students;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "signature"
    )
    private Set<GradeEntity> grades;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "signatures"
    )
    private Set<CourseEntity> courses;
}
