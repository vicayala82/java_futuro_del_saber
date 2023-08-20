package com.prueba.futuro_del_saber.services;

import com.prueba.futuro_del_saber.dto.CourseDTO;
import com.prueba.futuro_del_saber.dto.SignatureDTO;
import com.prueba.futuro_del_saber.entities.CourseEntity;
import com.prueba.futuro_del_saber.exceptions.CourseNotFoundException;
import com.prueba.futuro_del_saber.exceptions.SignatureNotFoundException;
import com.prueba.futuro_del_saber.exceptions.StudentNotFoundException;
import com.prueba.futuro_del_saber.repositories.CourseRepository;
import com.prueba.futuro_del_saber.repositories.SignatureRepository;
import com.prueba.futuro_del_saber.services.interfaces.ICrudInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements ICrudInterface<CourseDTO, Long> {

    @Autowired
    private final CourseRepository courseRepository;
    @Autowired
    private final SignatureRepository signatureRepository;
    @Override
    public CourseDTO create(CourseDTO courseDTO) {
        return CourseDTO.convertToDTO(courseRepository
                .save(CourseDTO.convertToEntity(courseDTO)));
    }

    @Override
    public CourseDTO get(Long courseId) {
        if(courseRepository.findById(courseId).isPresent()){
            return CourseDTO.convertToDTO(courseRepository.findById(courseId).get());
        }
        throw new StudentNotFoundException();
    }

    @Override
    public List<CourseDTO> getAll() {
        return courseRepository.findAll().stream()
                .map(CourseDTO::convertToDTO)
                .toList();
    }

    @Override
    public CourseDTO update(CourseDTO studentDTO, Long courseId) {
        Optional<CourseEntity> courseEntity = courseRepository.findById(courseId);
        if(courseEntity.isPresent()){
            return CourseDTO.convertToDTO(courseRepository
                    .save(CourseDTO.convertToEntity(studentDTO)));

        }
        throw new StudentNotFoundException();
    }

    @Override
    public void delete(Long courseId) {
        Optional<CourseEntity> courseEntity = courseRepository.findById(courseId);
        if(courseEntity.isPresent()){
            courseRepository.deleteById(courseId);

        }
        throw new StudentNotFoundException();
    }

    public void addSignature(CourseDTO courseDTO, SignatureDTO signatureDTO){
        signatureRepository.findById(signatureDTO.getId())
                .orElseThrow(SignatureNotFoundException::new);
        courseRepository.findById(courseDTO.getId())
                .orElseThrow(CourseNotFoundException::new);
        courseDTO.addSignature(signatureDTO);

    }

    public void removeSignature(CourseDTO courseDTO, SignatureDTO signatureDTO){
        signatureRepository.findById(signatureDTO.getId())
                .orElseThrow(SignatureNotFoundException::new);
        courseRepository.findById(courseDTO.getId())
                .orElseThrow(CourseNotFoundException::new);
        courseDTO.removeSignature(signatureDTO);
    }


}
