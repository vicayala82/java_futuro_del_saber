package com.prueba.futuro_del_saber.controllers;

import com.prueba.futuro_del_saber.dto.StudentDTO;
import com.prueba.futuro_del_saber.services.StudentServiceImpl;
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
@RequestMapping(path = "/students")
@AllArgsConstructor
public class StudentController {
    @Autowired
    private final StudentServiceImpl studentService;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll(){
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDTO> getById(@PathVariable Long studentId){
        return  ResponseEntity.ok(studentService.get(studentId));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> create(@RequestBody StudentDTO student){
        return  ResponseEntity.ok(studentService.create(student));
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentDTO> update(@RequestBody StudentDTO student,
                                             @PathVariable Long studentId){
        return  ResponseEntity.ok(studentService.update(student, studentId));
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> delete(@PathVariable Long studentId){
        studentService.delete(studentId);
        return  ResponseEntity.ok().build();
    }

}
