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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @JoinTable(name = "course_signature",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "signature_id"))
    private Set<SignatureEntity> signatures;
}
