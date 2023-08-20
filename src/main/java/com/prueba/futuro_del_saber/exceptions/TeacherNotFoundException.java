package com.prueba.futuro_del_saber.exceptions;

import com.prueba.futuro_del_saber.Constants.ServiceConstants;
import org.springframework.http.HttpStatus;

public class TeacherNotFoundException extends AplicationException{

    public TeacherNotFoundException(){
        super(HttpStatus.NOT_FOUND.getReasonPhrase(),
            ServiceConstants.NOT_FOUND_TEACHER, HttpStatus.NOT_FOUND.value());
    }
}
