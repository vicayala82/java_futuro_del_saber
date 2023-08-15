package com.prueba.futuro_del_saber.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Entity
@Table(name = "student")
public class StudentEntity {

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
    @Column(name = "CUSTODIAN_NAME", length = 100)
    private String custodianName;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    private AddressEntity address;

    @ManyToOne
    @JoinColumn(name = "COURSE_ID")
    private CourseEntity course;

    @ManyToMany
    @JoinTable(name = "STUDENT_SIGNATURE",
            joinColumns = @JoinColumn(name = "STUDENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "SIGNATURE_ID"))
    private Set<SignatureEntity> signatures;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "student"
    )
    private Set<GradeEntity> grades;
}
