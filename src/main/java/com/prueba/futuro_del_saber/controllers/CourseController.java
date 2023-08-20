package com.prueba.futuro_del_saber.controllers;

import com.prueba.futuro_del_saber.dto.CourseDTO;
import com.prueba.futuro_del_saber.services.CourseServiceImpl;
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
@RequestMapping(path = "/courses")
@AllArgsConstructor
public class CourseController {
    @Autowired
    private final CourseServiceImpl courseService;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAll(){
        return ResponseEntity.ok(courseService.getAll());
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseDTO> getById(@PathVariable Long courseId){
        return  ResponseEntity.ok(courseService.get(courseId));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> create(@RequestBody CourseDTO courseDTO){
        return  ResponseEntity.ok(courseService.create(courseDTO));
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<CourseDTO> update(@RequestBody CourseDTO courseDTO,
                                             @PathVariable Long courseId){
        return  ResponseEntity.ok(courseService.update(courseDTO, courseId));
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> delete(@PathVariable Long courseId){
        courseService.delete(courseId);
        return  ResponseEntity.ok().build();
    }

}
