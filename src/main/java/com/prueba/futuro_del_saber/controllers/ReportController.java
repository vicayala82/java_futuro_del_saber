package com.prueba.futuro_del_saber.controllers;

import com.prueba.futuro_del_saber.services.ReportService;
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
@RequestMapping(path = "/reports")
@AllArgsConstructor
public class ReportController {

    @Autowired
    private final ReportService reportService;

    @GetMapping("/over_average/{courseName}")
    public ResponseEntity<Set<OverAverageStudentResponseVO>> queryOverAverageStudent
            (@PathVariable String courseName){
        return ResponseEntity.ok(reportService.overAverageStudentsPerCourse(courseName));
    }

    @GetMapping("/best_students/{courseName}")
    public ResponseEntity<Set<BestStudentPerCourseVO>> bestStudentPerCourse
            (@PathVariable String courseName){
        return ResponseEntity.ok(reportService.bestStudentPerCourse(courseName));
    }

}
