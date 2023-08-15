package com.prueba.futuro_del_saber.dto;

import com.prueba.futuro_del_saber.entities.CourseEntity;
import com.prueba.futuro_del_saber.entities.SignatureEntity;
import com.prueba.futuro_del_saber.entities.TeacherEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
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
}
