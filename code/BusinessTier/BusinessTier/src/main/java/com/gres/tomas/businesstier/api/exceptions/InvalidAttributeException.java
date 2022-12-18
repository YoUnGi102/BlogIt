package com.gres.tomas.businesstier.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidAttributeException extends ResponseStatusException {

    public InvalidAttributeException(String errorMessage){
        super(HttpStatus.UNPROCESSABLE_ENTITY, errorMessage);
    }
}
