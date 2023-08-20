package com.prueba.futuro_del_saber.exceptions;

import com.prueba.futuro_del_saber.Constants.ServiceConstants;
import org.springframework.http.HttpStatus;

public class SignatureAlreadyOwnedException extends AplicationException{

    public SignatureAlreadyOwnedException(){
        super(HttpStatus.NOT_FOUND.getReasonPhrase(),
            ServiceConstants.SIGNATURE_ALREADY_OWNED, HttpStatus.NOT_FOUND.value());
    }
}
