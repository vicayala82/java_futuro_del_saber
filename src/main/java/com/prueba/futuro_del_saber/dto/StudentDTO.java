package com.prueba.futuro_del_saber.dto;


import com.prueba.futuro_del_saber.entities.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long id;
    private String documentType;
    private String name;
    private String lastName;
    private LocalDate birthday;
    private String email;
    private String phoneNumber;
    private String cellNumber;
    private String custodianName;
    private AddressDTO address;
    private CourseDTO course;
    private Set<SignatureDTO> signatures;
    private Set<GradeDTO> grades;

    public static StudentDTO convertToDTO(StudentEntity studentEntity){
        return StudentDTO.builder()
                .id(studentEntity.getId())
                .documentType(studentEntity.getDocumentType())
                .name(studentEntity.getName())
                .lastName(studentEntity.getLastName())
                .birthday(studentEntity.getBirthday())
                .email(studentEntity.getEmail())
                .phoneNumber(studentEntity.getPhoneNumber())
                .cellNumber(studentEntity.getCellNumber())
                .custodianName(studentEntity.getCustodianName())
                .address(AddressDTO.convertToDTO(studentEntity.getAddress()))
                .signatures(studentEntity.getSignatures().stream()
                        .map(SignatureDTO::convertToDTO)
                        .collect(Collectors.toSet())
                )
                .grades(studentEntity.getGrades().stream()
                        .map(GradeDTO::convertToDTO)
                        .collect(Collectors.toSet())
                )
                .build();
    }
}
