package com.gres.tomas.businesstier.api.exceptions;

import org.springframework.http.HttpStatus;

public abstract class ErrorCodeMapper {

    public static void mapCodeToException(HttpStatus code, String message){
        switch (code){
            case CONFLICT -> throw new EntityAlreadyExistsException(message);
            case NOT_FOUND -> throw new EntityNotFoundException(message);
            case UNPROCESSABLE_ENTITY -> throw new InvalidAttributeException(message);
        }
    }

}
