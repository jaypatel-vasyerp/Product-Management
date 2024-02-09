package com.jayptl.learningjpa.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jayptl.learningjpa.dto.ResponseDto;
import com.jayptl.learningjpa.exception.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseDto EntityNotFoundException(EntityNotFoundException exception){
        return new ResponseDto(404,"Error",exception.getMessage());
    }
    
}
