package com.prueba.futuro_del_saber.controllers;

import com.prueba.futuro_del_saber.dto.GradeDTO;
import com.prueba.futuro_del_saber.services.GradesServiceImpl;
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
@RequestMapping(path = "/grades")
@AllArgsConstructor
public class GradeController {
    @Autowired
    private final GradesServiceImpl gradesService;

    @GetMapping
    public ResponseEntity<List<GradeDTO>> findAll(){
        return ResponseEntity.ok(gradesService.getAll());
    }

    @GetMapping("/{gradeId}")
    public ResponseEntity<GradeDTO> getById(@PathVariable Long gradeId){
        return  ResponseEntity.ok(gradesService.get(gradeId));
    }

    @PostMapping
    public ResponseEntity<GradeDTO> create(@RequestBody GradeDTO student){
        return  ResponseEntity.ok(gradesService.create(student));
    }

    @PutMapping("/{gradeId}")
    public ResponseEntity<GradeDTO> update(@RequestBody GradeDTO student,
                                             @PathVariable Long gradeId){
        return  ResponseEntity.ok(gradesService.update(student, gradeId));
    }

    @DeleteMapping("/{gradeId}")
    public ResponseEntity<Void> delete(@PathVariable Long gradeId){
        gradesService.delete(gradeId);
        return  ResponseEntity.ok().build();
    }

}
