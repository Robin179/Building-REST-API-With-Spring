package com.prajjwal.rest.webservices.restfulwebservices.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloWorldController {
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hey there! I am world! how are you?";
    }
}
