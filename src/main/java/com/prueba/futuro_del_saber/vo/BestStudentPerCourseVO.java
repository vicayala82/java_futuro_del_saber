package com.prueba.futuro_del_saber.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BestStudentPerCourseVO {

    @JsonProperty("director_del_curso")
    private String courseDirector;
    @JsonProperty("curso")
    private String courseName;
    @JsonProperty("promedio_del_curso")
    private double courseAverage;
    @JsonProperty("nombre_del_estudiante")
    private String student;
    @JsonProperty("notas_por_asignatura")
    private Set<SignatureVO> gradesSignatures;
    @JsonProperty ("promedio_estudiante")
    private double studentAverage;
}
