package org.example.handlers;

import org.example.exceptions.FirstException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class Firsthandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FirstException.class)
    public ResponseEntity handlerFirs(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "Wrong Link ", new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

}
