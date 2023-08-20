package com.prueba.futuro_del_saber.exceptions;

import com.prueba.futuro_del_saber.Constants.ServiceConstants;
import org.springframework.http.HttpStatus;

public class CourseNotFoundException extends AplicationException{

    public CourseNotFoundException(){
        super(HttpStatus.NOT_FOUND.getReasonPhrase(),
            ServiceConstants.NOT_FOUND_COURSE, HttpStatus.NOT_FOUND.value());
    }
}
