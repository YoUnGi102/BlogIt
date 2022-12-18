package com.gres.tomas.businesstier.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EntityAlreadyExistsException extends ResponseStatusException {

    public EntityAlreadyExistsException(String message){
        super(HttpStatus.CONFLICT, message);
    }
}
