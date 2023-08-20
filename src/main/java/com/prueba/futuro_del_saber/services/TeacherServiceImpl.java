package com.prueba.futuro_del_saber.services;

import com.prueba.futuro_del_saber.dto.TeacherDTO;
import com.prueba.futuro_del_saber.entities.TeacherEntity;
import com.prueba.futuro_del_saber.exceptions.TeacherNotFoundException;
import com.prueba.futuro_del_saber.repositories.TeacherRepository;
import com.prueba.futuro_del_saber.services.interfaces.ICrudInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements ICrudInterface<TeacherDTO, Long> {

    @Autowired
    private final TeacherRepository teacherRepository;
    @Override
    public TeacherDTO create(TeacherDTO teacherDTO) {
        return TeacherDTO.convertDTO(teacherRepository
            .save(TeacherDTO.convertToEntity(teacherDTO)));
    }

    @Override
    public TeacherDTO get(Long teacherId) {
        if(teacherRepository.findById(teacherId).isPresent()){
            return TeacherDTO.convertDTO(teacherRepository.findById(teacherId).get());
        }
        throw new TeacherNotFoundException();
    }

    @Override
    public List<TeacherDTO> getAll() {
        return teacherRepository.findAll().stream()
                .map(TeacherDTO::convertDTO)
                .toList();
    }

    @Override
    public TeacherDTO update(TeacherDTO teacherDTO, Long teacherId) {
        Optional<TeacherEntity> teacherEntity = teacherRepository.findById(teacherId);
        if(teacherEntity.isPresent()){
            return TeacherDTO.convertDTO(teacherRepository
                .save(TeacherDTO.convertToEntity(teacherDTO)));

        }
        throw new TeacherNotFoundException();
    }

    @Override
    public void delete(Long teacherId) {
        Optional<TeacherEntity> teacherEntity = teacherRepository.findById(teacherId);
        if(teacherEntity.isPresent()){
            teacherRepository.deleteById(teacherId);

        }
        throw new TeacherNotFoundException();
    }
}
