package com.prueba.futuro_del_saber.dto;

import com.prueba.futuro_del_saber.entities.SignatureEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignatureDTO {

    private Long id;
    private String name;
    private TeacherDTO teacher;

    public static SignatureDTO convertToDTO (SignatureEntity signatureEntity){
        return SignatureDTO.builder()
                .id(signatureEntity.getId())
                .name(signatureEntity.getName())
                .teacher(TeacherDTO.convertDTO(signatureEntity.getTeacher()))
                .build();
    }
    public static SignatureEntity convertToEntity (SignatureDTO signatureDTO){
        return SignatureEntity.builder()
                .id(signatureDTO.getId())
                .name(signatureDTO.getName())
                .teacher(TeacherDTO.convertToEntity(signatureDTO.getTeacher()))
                .build();
    }
}
