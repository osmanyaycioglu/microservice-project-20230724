package com.training.micro.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(IllegalArgumentException exp) {
        return ErrorObj.builder()
                       .withDesc(exp.getMessage())
                       .withErrorCode(1000)
                       .build();
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(IllegalStateException exp) {
        return ErrorObj.builder()
                       .withDesc(exp.getMessage())
                       .withErrorCode(1001)
                       .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(MethodArgumentNotValidException exp) {
        return ErrorObj.builder()
                       .withDesc("validation error")
                       .withErrorCode(1002)
                       .withSubErrors(exp.getAllErrors()
                                         .stream()
                                         .map(er -> ErrorObj.builder()
                                                            .withDesc(er.toString())
                                                            .withErrorCode(1003)
                                                            .build())
                                         .collect(Collectors.toList()))
                       .build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handleException(Exception exp) {
        if (exp instanceof NullPointerException) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                                 .body(ErrorObj.builder()
                                               .withDesc(exp.getMessage())
                                               .withErrorCode(1000)
                                               .build());

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(ErrorObj.builder()
                                           .withDesc(exp.getMessage())
                                           .withErrorCode(1000)
                                           .build());
    }


}
