package com.prueba.futuro_del_saber.exceptions;

import com.prueba.futuro_del_saber.Constants.ServiceConstants;
import org.springframework.http.HttpStatus;

public class SignatureNotFoundException extends AplicationException{

    public SignatureNotFoundException(){
        super(HttpStatus.NOT_FOUND.getReasonPhrase(),
            ServiceConstants.NOT_FOUND_SIGNATURE, HttpStatus.NOT_FOUND.value());
    }
}
