package com.gres.tomas.businesstier.domain.helper;

import java.util.ArrayList;
import java.util.List;

public class ValidationError {

    private final List<String[]> errors;

    public ValidationError(){
        errors = new ArrayList<>();
    }

    public void addError(String name, String message){
        errors.add(new String[]{name, message});
    }

    public String getJSONString(){
        StringBuilder json = new StringBuilder();
        json.append("{");
        for (int i = 0; i < errors.size(); i++) {
            json.append('"').append(errors.get(i)[0]).append("\":\"")
                    .append(errors.get(i)[1]).append("\"");
            if(i+1 < errors.size())
                json.append(",");
        }
        json.append("}");
        return json.toString();
    }

    public boolean hasErrors(){
        return errors.size() > 0;
    }

}
