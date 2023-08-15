package com.prueba.futuro_del_saber.controllers;

import com.prueba.futuro_del_saber.services.CourseService;
import com.prueba.futuro_del_saber.vo.BestStudentPerCourseVO;
import com.prueba.futuro_del_saber.vo.OverAverageStudentResponseVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path = "/query")
@AllArgsConstructor
public class CourseController {

    @Autowired
    private final CourseService courseService;

    @GetMapping("/over_average/{courseName}")
    public ResponseEntity<Set<OverAverageStudentResponseVO>> queryOverAverageStudent
            (@PathVariable String courseName){
        return ResponseEntity.ok(courseService.overAverageStudentsPerCourse(courseName));
    }

    @GetMapping("/best_students/{courseName}")
    public ResponseEntity<Set<BestStudentPerCourseVO>> bestStudentPerCourse
            (@PathVariable String courseName){
        return ResponseEntity.ok(courseService.bestStudentPerCourse(courseName));
    }

}
