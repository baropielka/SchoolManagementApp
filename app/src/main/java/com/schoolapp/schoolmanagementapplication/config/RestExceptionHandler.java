package com.schoolapp.schoolmanagementapplication.config;

import com.schoolapp.schoolmanagementapplication.exception.AuthorizationException;
import com.schoolapp.schoolmanagementapplication.exception.ErrorSto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {AuthorizationException.class})
    public ResponseEntity<ErrorSto> handleException(AuthorizationException exception) {
        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(new ErrorSto(exception.getMessage()));
    }
}
