package com.prueba.futuro_del_saber.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "teacher")
public class TeacherEntity {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "DOCUMENT_TYPE", length = 50)
    private String documentType;
    @Column(name = "NAME", length = 100)
    private String name;
    @Column(name = "LAST_NAME", length = 100)
    private String lastName;
    @Column(name = "BIRTHDAY")
    private LocalDate birthday;
    @Column(name ="EMAIL", length = 100)
    private String email;
    @Column(name="PHONE_NUMBER", length = 20)
    private String phoneNumber;
    @Column(name = "CELL_NUMBER",length = 20)
    private String cellNumber;
    @Column(name = "LAST_GRADE")
    private String lastGrade;
    @OneToOne(mappedBy = "courseDirector")
    private CourseEntity courseAssigned;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "teacher"
    )
    private Set<SignatureEntity> signatures;


}
