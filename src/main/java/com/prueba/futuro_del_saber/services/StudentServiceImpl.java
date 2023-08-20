package com.prueba.futuro_del_saber.services;

import com.prueba.futuro_del_saber.dto.StudentDTO;
import com.prueba.futuro_del_saber.entities.StudentEntity;
import com.prueba.futuro_del_saber.exceptions.StudentNotFoundException;
import com.prueba.futuro_del_saber.repositories.StudentRepository;
import com.prueba.futuro_del_saber.services.interfaces.ICrudInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements ICrudInterface<StudentDTO, Long> {

    @Autowired
    private final StudentRepository studentRepository;
    @Override
    public StudentDTO create(StudentDTO studentDto) {
        return StudentDTO.convertToDTO(studentRepository
                .save(StudentDTO.convertToEntity(studentDto)));
    }

    @Override
    public StudentDTO get(Long studentId) {
        if(studentRepository.findById(studentId).isPresent()){
            return StudentDTO.convertToDTO(studentRepository.findById(studentId).get());
        }
        throw new StudentNotFoundException();
    }

    @Override
    public List<StudentDTO> getAll() {
        return studentRepository.findAll().stream()
                .map(StudentDTO::convertToDTO)
                .toList();
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO, Long studentId) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);
        if(studentEntity.isPresent()){
            return StudentDTO.convertToDTO(studentRepository
                    .save(StudentDTO.convertToEntity(studentDTO)));

        }
        throw new StudentNotFoundException();
    }

    @Override
    public void delete(Long studentId) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);
        if(studentEntity.isPresent()){
            studentRepository.deleteById(studentId);

        }
        throw new StudentNotFoundException();
    }
}
