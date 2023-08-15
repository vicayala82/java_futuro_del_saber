package com.prueba.futuro_del_saber.dto;

import com.prueba.futuro_del_saber.entities.CourseEntity;
import com.prueba.futuro_del_saber.entities.GradeEntity;
import com.prueba.futuro_del_saber.entities.SignatureEntity;
import com.prueba.futuro_del_saber.entities.StudentEntity;
import com.prueba.futuro_del_saber.entities.TeacherEntity;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

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
}
