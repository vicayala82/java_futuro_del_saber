package com.prueba.futuro_del_saber.dto;

import com.prueba.futuro_del_saber.entities.TeacherEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO{
    private Long id;
    private String documentType;
    private String name;
    private String lastName;
    private LocalDate birthday;
    private String email;
    private String phoneNumber;
    private String cellNumber;
    private String lastGrade;

    public static TeacherDTO convertDTO(TeacherEntity teacherEntity){
        return TeacherDTO.builder()
                .id(teacherEntity.getId())
                .documentType(teacherEntity.getDocumentType())
                .name(teacherEntity.getName())
                .lastName(teacherEntity.getLastName())
                .birthday(teacherEntity.getBirthday())
                .email(teacherEntity.getEmail())
                .phoneNumber(teacherEntity.getPhoneNumber())
                .cellNumber(teacherEntity.getCellNumber())
                .lastGrade(teacherEntity.getLastGrade())
                .build();
    }


}
