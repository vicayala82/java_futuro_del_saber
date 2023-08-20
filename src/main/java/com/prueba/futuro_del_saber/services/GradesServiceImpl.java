package com.prueba.futuro_del_saber.services;

import com.prueba.futuro_del_saber.dto.GradeDTO;
import com.prueba.futuro_del_saber.entities.GradeEntity;
import com.prueba.futuro_del_saber.exceptions.SignatureNotFoundException;
import com.prueba.futuro_del_saber.exceptions.StudentNotFoundException;
import com.prueba.futuro_del_saber.repositories.GradeRepository;
import com.prueba.futuro_del_saber.repositories.SignatureRepository;
import com.prueba.futuro_del_saber.repositories.StudentRepository;
import com.prueba.futuro_del_saber.services.interfaces.ICrudInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GradesServiceImpl implements ICrudInterface<GradeDTO, Long> {

    @Autowired
    private final GradeRepository gradeRepository;
    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final SignatureRepository signatureRepository;
    @Override
    public GradeDTO create(GradeDTO gradeDTO) {
        studentRepository.findById(gradeDTO.getStudent().getId())
                .orElseThrow(StudentNotFoundException::new);
        signatureRepository.findById(gradeDTO.getSignature().getId())
                .orElseThrow(SignatureNotFoundException::new);
        return GradeDTO.convertToDTO(gradeRepository
                .save(GradeDTO.convertToEntity(gradeDTO)));
    }

    @Override
    public GradeDTO get(Long courseId) {
        if(gradeRepository.findById(courseId).isPresent()){
            return GradeDTO.convertToDTO(gradeRepository.findById(courseId).get());
        }
        throw new StudentNotFoundException();
    }

    @Override
    public List<GradeDTO> getAll() {
        return gradeRepository.findAll().stream()
                .map(GradeDTO::convertToDTO)
                .toList();
    }

    @Override
    public GradeDTO update(GradeDTO gradeDTO, Long courseId) {
        studentRepository.findById(gradeDTO.getStudent().getId())
                .orElseThrow(StudentNotFoundException::new);
        signatureRepository.findById(gradeDTO.getSignature().getId())
                .orElseThrow(SignatureNotFoundException::new);
        Optional<GradeEntity> gradeEntity = gradeRepository.findById(courseId);
        if(gradeEntity.isPresent()){
            return GradeDTO.convertToDTO(gradeRepository
                    .save(GradeDTO.convertToEntity(gradeDTO)));

        }
        throw new StudentNotFoundException();
    }

    @Override
    public void delete(Long courseId) {
        Optional<GradeEntity> gradeEntity = gradeRepository.findById(courseId);
        if(gradeEntity.isPresent()){
            gradeRepository.deleteById(courseId);

        }
        throw new StudentNotFoundException();
    }
    
}
