package com.prueba.futuro_del_saber.dto;

import com.prueba.futuro_del_saber.entities.GradeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GradeDTO {

    private Long id;
    private double value;
    private SignatureDTO signature;
    private StudentDTO student;

    public static GradeDTO convertToDTO(GradeEntity gradeEntity){
        return GradeDTO.builder()
                .id(gradeEntity.getId())
                .value(gradeEntity.getValue())
                .signature(SignatureDTO.convertToDTO(gradeEntity.getSignature()))
                .build();
    }
}
