package com.prueba.futuro_del_saber.exceptions;

import com.prueba.futuro_del_saber.Constants.ServiceConstants;
import org.springframework.http.HttpStatus;

public class StudentNotFoundException extends AplicationException{

    public StudentNotFoundException(){
        super(HttpStatus.NOT_FOUND.getReasonPhrase(),
            ServiceConstants.NOT_FOUND_STUDENT, HttpStatus.NOT_FOUND.value());
    }
}
