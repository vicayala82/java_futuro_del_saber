package com.prueba.futuro_del_saber.services;

import com.prueba.futuro_del_saber.dto.SignatureDTO;
import com.prueba.futuro_del_saber.entities.SignatureEntity;
import com.prueba.futuro_del_saber.exceptions.SignatureNotFoundException;
import com.prueba.futuro_del_saber.exceptions.TeacherNotFoundException;
import com.prueba.futuro_del_saber.repositories.SignatureRepository;
import com.prueba.futuro_del_saber.repositories.TeacherRepository;
import com.prueba.futuro_del_saber.services.interfaces.ICrudInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SignatureServiceImpl implements ICrudInterface<SignatureDTO, Long> {

    @Autowired
    private final SignatureRepository signatureRepository;
    @Autowired
    private final TeacherRepository teacherRepository;
    @Override
    public SignatureDTO create(SignatureDTO signatureDTO) {
        teacherRepository.findById(signatureDTO.getTeacher().getId())
            .orElseThrow(TeacherNotFoundException::new);
        return SignatureDTO.convertToDTO(signatureRepository
                .save(SignatureDTO.convertToEntity(signatureDTO)));
    }

    @Override
    public SignatureDTO get(Long signatureId) {
        if(signatureRepository.findById(signatureId).isPresent()){
            return SignatureDTO.convertToDTO(signatureRepository.findById(signatureId).get());
        }
        throw new SignatureNotFoundException();
    }

    @Override
    public List<SignatureDTO> getAll() {
        return signatureRepository.findAll().stream()
                .map(SignatureDTO::convertToDTO)
                .toList();
    }

    @Override
    public SignatureDTO update(SignatureDTO signatureDTO, Long signatureId) {
        teacherRepository.findById(signatureDTO.getTeacher().getId())
            .orElseThrow(TeacherNotFoundException::new);
        Optional<SignatureEntity> studentEntity = signatureRepository.findById(signatureId);
        if(studentEntity.isPresent()){
            return SignatureDTO.convertToDTO(signatureRepository
                    .save(SignatureDTO.convertToEntity(signatureDTO)));

        }
        throw new SignatureNotFoundException();
    }

    @Override
    public void delete(Long signatureId) {
        Optional<SignatureEntity> signatureEntity = signatureRepository.findById(signatureId);
        if(signatureEntity.isPresent()){
            signatureRepository.deleteById(signatureId);

        }
        throw new SignatureNotFoundException();
    }

}
