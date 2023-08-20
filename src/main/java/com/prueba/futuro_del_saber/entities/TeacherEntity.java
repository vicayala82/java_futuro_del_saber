package com.prueba.futuro_del_saber.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
