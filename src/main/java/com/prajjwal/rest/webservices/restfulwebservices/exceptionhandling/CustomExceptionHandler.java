package com.prajjwal.rest.webservices.restfulwebservices.exceptionhandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    ResponseEntity<Object> handleCustomException(Exception ex, WebRequest request) throws Exception {
        ErrorDetails errorDetails = ErrorDetails.builder().date(LocalDateTime.now())
                .message(ex.getMessage())
                .description(request.getDescription(true)).build();

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
