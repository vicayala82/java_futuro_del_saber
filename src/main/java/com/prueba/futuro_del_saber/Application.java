package com.prueba.futuro_del_saber;

import com.prueba.futuro_del_saber.services.CourseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
public class Application{

    @Autowired
    private final CourseService courseService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
        log.info("Run Application Futuro Del Saber");

    }

}