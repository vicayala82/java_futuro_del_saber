package com.prueba.futuro_del_saber.services;

import com.prueba.futuro_del_saber.dto.CourseDTO;
import com.prueba.futuro_del_saber.dto.GradeDTO;
import com.prueba.futuro_del_saber.dto.StudentDTO;
import com.prueba.futuro_del_saber.repositories.*;
import com.prueba.futuro_del_saber.vo.BestStudentPerCourseVO;
import com.prueba.futuro_del_saber.vo.OverAverageStudentResponseVO;
import com.prueba.futuro_del_saber.vo.SignatureVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ReportService {

    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final TeacherRepository teacherRepository;
    @Autowired
    private final SignatureRepository signatureRepository;
    @Autowired
    private final GradeRepository gradeRepository;
    @Autowired
    private final CourseRepository courseRepository;

    public Set<OverAverageStudentResponseVO> overAverageStudentsPerCourse(String courseName){
        CourseDTO course = CourseDTO.convertToDTO(courseRepository.findByLevelCourse(courseName));
        Set<StudentDTO> students = studentRepository.findByCourseId(course.getId()).stream()
                .map(StudentDTO::convertToDTO)
                .collect(Collectors.toSet());
        double average = students.stream()
                .flatMap(studentDTO -> studentDTO.getGrades().stream())
                .mapToDouble(GradeDTO::getValue)
                .average()
                .orElse(0.0);
        return students.stream()
                .filter(student ->{
                    var avg = student.getGrades().stream()
                            .mapToDouble(GradeDTO::getValue)
                            .average();
                    return avg.getAsDouble() > average;
                    })
                .map(studentDTO -> OverAverageStudentResponseVO.builder()
                            .course(course.getLevelCourse())
                            .teacher(course.getCourseDirector().getName()+" "+course.getCourseDirector().getLastName())
                            .average(average)
                            .studentName(studentDTO.getName()+" "+studentDTO.getLastName())
                            .signatures(studentDTO.getGrades().stream()
                                    .map(SignatureVO::convertToVO)
                                    .collect(Collectors.toSet())
                            )
                            .grade(studentDTO.getGrades().stream()
                                    .mapToDouble(GradeDTO::getValue)
                                    .average()
                                    .getAsDouble()
                            )
                            .build()
                ).collect(Collectors.toSet());
    }

    public Set<BestStudentPerCourseVO> bestStudentPerCourse(String courseName) {
        CourseDTO course = CourseDTO.convertToDTO(courseRepository.findByLevelCourse(courseName));
        Set<StudentDTO> students = studentRepository.findByCourseId(course.getId()).stream()
                .map(StudentDTO::convertToDTO)
                .collect(Collectors.toSet());
        double average = students.stream()
                .flatMap(studentDTO -> studentDTO.getGrades().stream())
                .mapToDouble(GradeDTO::getValue)
                .average()
                .orElse(0.0);
        double bestAverage = students.stream()
                .mapToDouble(studentDTO -> studentDTO.getGrades().stream()
                        .mapToDouble(GradeDTO::getValue).average().getAsDouble())
                .max().getAsDouble();

        return students.stream()
                .filter(student ->{
                    var avr = student.getGrades().stream()
                            .mapToDouble(GradeDTO::getValue)
                            .average();
                    return avr.getAsDouble() == bestAverage;
                })
                .map(studentDTO -> BestStudentPerCourseVO.builder()
                            .courseName(course.getLevelCourse())
                            .courseDirector(course.getCourseDirector().getName()+" "+course.getCourseDirector().getLastName())
                            .courseAverage(average)
                            .student(studentDTO.getName()+" "+studentDTO.getLastName())
                            .gradesSignatures(studentDTO.getGrades().stream()
                                    .map(SignatureVO::convertToVO)
                                    .collect(Collectors.toSet())
                            )
                            .studentAverage(studentDTO.getGrades().stream()
                                    .mapToDouble(GradeDTO::getValue)
                                    .average()
                                    .getAsDouble()
                            )
                            .build()
                ).collect(Collectors.toSet());
    }
}
