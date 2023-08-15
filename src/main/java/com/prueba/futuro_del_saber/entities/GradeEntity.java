package com.prueba.futuro_del_saber.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "grade")
public class GradeEntity {

    @Id
    @Column(name ="ID")
    private Long id;

    @Column(name ="VALUE")
    private double value;

    @ManyToOne
    @JoinColumn(name ="SIGNATURE_ID")
    private SignatureEntity signature;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    private StudentEntity student;

}
