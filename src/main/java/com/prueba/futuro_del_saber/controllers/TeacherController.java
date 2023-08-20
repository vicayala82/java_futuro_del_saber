package com.prueba.futuro_del_saber.controllers;

import com.prueba.futuro_del_saber.dto.TeacherDTO;
import com.prueba.futuro_del_saber.services.TeacherServiceImpl;
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
@AllArgsConstructor
@RequestMapping(path = "/teachers")
public class TeacherController {

    @Autowired
    TeacherServiceImpl teacherService;

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> findAll(){
        return ResponseEntity.ok(teacherService.getAll());
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<TeacherDTO> getById(@PathVariable Long teacherId){
        return  ResponseEntity.ok(teacherService.get(teacherId));
    }

    @PostMapping
    public ResponseEntity<TeacherDTO> create(@RequestBody TeacherDTO teacher){
        return  ResponseEntity.ok(teacherService.create(teacher));
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<TeacherDTO> update(@RequestBody TeacherDTO teacher,
        @PathVariable Long teacherId){
        return  ResponseEntity.ok(teacherService.update(teacher, teacherId));
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<Void> delete(@PathVariable Long teacherId){
        teacherService.delete(teacherId);
        return  ResponseEntity.ok().build();
    }



}
