package com.prajjwal.rest.webservices.restfulwebservices.models;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFounfException extends RuntimeException{
    public UserNotFounfException(String noSuchUserExists) {
        super(noSuchUserExists);
    }
}
