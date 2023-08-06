package com.prajjwal.rest.webservices.restfulwebservices.controllers;

import com.prajjwal.rest.webservices.restfulwebservices.models.HelloWorldBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloWorldController {
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hey there! I am world! how are you?";
    }
    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("prajjwal");
    }

    // what is happening in the background is that when you make a request to url 'http://localhoat:8080/hello-worl-bean'
    // the request first goes to what is called a 'DispatcherServlet', the dispatcherServlet routes the request to appropriate
    // controller method. Now,  how this dispatcher servlet is configured? it is because of spring-boot's Auto Configuration
    // features, when it sees that there is a class that is related to web services ex-> for making APIs (Spring web)
    // it automatically configures a dispatcher servlet for your spring-boot application.

    // Now what about the response JSON that you receive back on the browser, this response is provided in the form
    // of JSON using a Jackson frame which is also autoconfigured due to spring-boot, as we add different dependencies
    // in our project, we install the JARs associated to them in our project. Seeing all these java classes and JARs in class
    // path Spring-boot set the configuration automatically.

    // Even the error page that you receive on making a request on a wrong endpoint you, is AutoConfigured as a
    // part of ErrorMVCAutoConfiguration.

}
