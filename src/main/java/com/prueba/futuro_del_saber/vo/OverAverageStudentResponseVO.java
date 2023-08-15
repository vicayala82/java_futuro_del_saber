package com.prueba.futuro_del_saber.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OverAverageStudentResponseVO {

    @JsonProperty("profesor")
    private String teacher;
    @JsonProperty("curso")
    private String course;
    @JsonProperty( "asignaturas")
    private Set<SignatureVO> signatures;
    @JsonProperty( "promedio_curso")
    private double average;
    @JsonProperty("estudiante")
    private String studentName;
    @JsonProperty("nota promedio")
    private double grade;

}
