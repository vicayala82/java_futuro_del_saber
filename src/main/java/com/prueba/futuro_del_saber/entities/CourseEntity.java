package com.prueba.futuro_del_saber.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "course")
public class CourseEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "LEVEL_COURSE", length = 10)
    private String levelCourse;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_director_id", referencedColumnName = "id")
    private TeacherEntity courseDirector;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "COURSE_SIGNATURE",
            joinColumns = @JoinColumn(name = "COURSE_ID"),
            inverseJoinColumns = @JoinColumn(name = "SIGNATURE_ID"))
    private Set<SignatureEntity> signatures;
}
