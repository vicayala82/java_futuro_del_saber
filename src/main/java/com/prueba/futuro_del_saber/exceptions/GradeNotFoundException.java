package com.prueba.futuro_del_saber.exceptions;

import com.prueba.futuro_del_saber.Constants.ServiceConstants;
import org.springframework.http.HttpStatus;

public class GradeNotFoundException extends AplicationException{

    public GradeNotFoundException(){
        super(HttpStatus.NOT_FOUND.getReasonPhrase(),
            ServiceConstants.NOT_FOUND_GRADE, HttpStatus.NOT_FOUND.value());
    }
}
