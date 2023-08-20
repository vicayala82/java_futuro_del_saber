package com.prueba.futuro_del_saber.dto;

import com.prueba.futuro_del_saber.entities.CourseEntity;
import com.prueba.futuro_del_saber.exceptions.SignatureAlreadyOwnedException;
import com.prueba.futuro_del_saber.exceptions.SignatureNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Long id;
    private String levelCourse;
    private TeacherDTO courseDirector;
    private Set<SignatureDTO> signatures;

    public static CourseDTO convertToDTO(CourseEntity courseEntity){
        return CourseDTO.builder()
                .id(courseEntity.getId())
                .levelCourse(courseEntity.getLevelCourse())
                .courseDirector(TeacherDTO.convertDTO(courseEntity.getCourseDirector()))
                .signatures(courseEntity.getSignatures().stream()
                        .map(SignatureDTO::convertToDTO)
                        .collect(Collectors.toSet())
                )
                .build();
    }

    public static CourseEntity convertToEntity(CourseDTO courseDTO){
        return CourseEntity.builder()
                .id(courseDTO.getId())
                .levelCourse(courseDTO.getLevelCourse())
                .courseDirector(TeacherDTO.convertToEntity(courseDTO.getCourseDirector()))
                .signatures(courseDTO.getSignatures().stream()
                        .map(SignatureDTO::convertToEntity)
                        .collect(Collectors.toSet())
                )
                .build();
    }

    public void addSignature(SignatureDTO signatureDTO) {
        if(this.getSignatures().contains(signatureDTO)){
            throw new SignatureAlreadyOwnedException();
        }
        this.getSignatures().add(signatureDTO);
    }
    public void removeSignature(SignatureDTO signatureDTO) {
        if(this.getSignatures().contains(signatureDTO)){
            this.getSignatures().remove(signatureDTO);
        }
        throw new SignatureNotFoundException();
    }
}
