package com.prueba.futuro_del_saber.controllers;

import com.prueba.futuro_del_saber.dto.SignatureDTO;
import com.prueba.futuro_del_saber.services.SignatureServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/signatures")
@AllArgsConstructor
public class SignatureController {
    @Autowired
    private final SignatureServiceImpl signatureService;

    @GetMapping
    public ResponseEntity<List<SignatureDTO>> findAll(){
        return ResponseEntity.ok(signatureService.getAll());
    }

    @GetMapping("/{signatureId}")
    public ResponseEntity<SignatureDTO> getById(@PathVariable Long signatureId){
        return  ResponseEntity.ok(signatureService.get(signatureId));
    }

    @PostMapping
    public ResponseEntity<SignatureDTO> create(@RequestBody SignatureDTO signatureDTO){
        return  ResponseEntity.ok(signatureService.create(signatureDTO));
    }

    @PutMapping("/{signatureId}")
    public ResponseEntity<SignatureDTO> update(@RequestBody SignatureDTO signatureDTO,
                                             @PathVariable Long signatureId){
        return  ResponseEntity.ok(signatureService.update(signatureDTO, signatureId));
    }

    @DeleteMapping("/{signatureId}")
    public ResponseEntity<Void> delete(@PathVariable Long signatureId){
        signatureService.delete(signatureId);
        return  ResponseEntity.ok().build();
    }

}
