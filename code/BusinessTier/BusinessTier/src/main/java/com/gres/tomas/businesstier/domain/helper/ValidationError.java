package com.gres.tomas.businesstier.domain.helper;

import com.gres.tomas.businesstier.api.exceptions.EntityAlreadyExistsException;
import com.gres.tomas.businesstier.api.exceptions.EntityNotFoundException;
import com.gres.tomas.businesstier.api.exceptions.ErrorCodeMapper;
import com.gres.tomas.businesstier.api.exceptions.InvalidAttributeException;
import org.springframework.http.HttpStatus;

import java.util.*;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.OK;

public class ValidationError {

    private final List<String[]> errors;
    private final Set<HttpStatus> exceptions;

    public ValidationError(){
        errors = new ArrayList<>();
        exceptions = new HashSet<>();
    }

    public void addError(String name, String message){
        errors.add(new String[]{name, message});
    }
    public void addError(String name, String message, HttpStatus code){
        addError(name, message);
        exceptions.add(code);
    }

    public String getJSONString(){
        StringBuilder json = new StringBuilder();
        List<String> errorNames = new ArrayList<>();
        json.append("{");
        for (int i = 0; i < errors.size(); i++) {
            if(errorNames.contains(errors.get(i)[0])){
                System.out.println(errors.get(i)[0]);
                continue;
            }
            json.append('"').append(errors.get(i)[0]).append("\":\"")
                    .append(errors.get(i)[1]).append("\"");
            if(i+1 < errors.size())
                json.append(",");
            errorNames.add(errors.get(i)[0]);
        }
        json.append("}");
        return json.toString();
    }

    public boolean hasErrors(){
        return errors.size() > 0;
    }

    public void throwFirstException() throws Throwable{
        HttpStatus status = exceptions.stream().findFirst().orElse(OK);
        ErrorCodeMapper.mapCodeToException(status, getJSONString());
    }

}
