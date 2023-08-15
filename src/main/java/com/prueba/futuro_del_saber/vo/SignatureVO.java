package com.prueba.futuro_del_saber.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.prueba.futuro_del_saber.dto.GradeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignatureVO {
    @JsonProperty("profesor")
    private String teacher;
    @JsonProperty("nombre_asignatura")
    private String signatureName;
    @JsonProperty("nota")
    private double grade;


    public static SignatureVO convertToVO(GradeDTO gradeDTO){
        return SignatureVO.builder()
                .signatureName(gradeDTO.getSignature().getName())
                .teacher(gradeDTO.getSignature().getTeacher().getName()+" "+
                        gradeDTO.getSignature().getTeacher().getLastName())
                .grade(gradeDTO.getValue())
                .build();
    }
}
