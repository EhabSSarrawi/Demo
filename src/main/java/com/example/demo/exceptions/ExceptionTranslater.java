package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.xml.crypto.MarshalException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionTranslater {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoElementFound(NoSuchElementException noSuchElementException) {
        return new ResponseEntity<>(noSuchElementException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MarshalException.class)
    public ResponseEntity<String> handleInvalidToken(MarshalException marshalException) {
        return new ResponseEntity<>(marshalException.getMessage(), HttpStatus.NON_AUTHORITATIVE_INFORMATION);
    }

}
