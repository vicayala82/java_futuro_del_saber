package com.prueba.futuro_del_saber.exceptions;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AplicationException extends RuntimeException{

    private final String code;
    private final String description;
    private final Integer statusCode;

    public AplicationException(String code, String description, Integer statusCode) {
        super(description);
        this.code = code;
        this.description = description;
        this.statusCode = statusCode;
    }

    public AplicationException(String code, String description, Integer statusCode, Throwable couse) {
        super(description, couse);
        this.code = code;
        this.description = description;
        this.statusCode = statusCode;
    }
}
