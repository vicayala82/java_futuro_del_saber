package com.prueba.futuro_del_saber.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
