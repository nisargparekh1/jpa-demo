package io.pragra.learning.pragravisit.controller.rest;

import io.pragra.learning.pragravisit.exceptions.InvalidDataException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<PragraError> handleInvalidId(InvalidDataException ex, WebRequest request){
        PragraError id101 = PragraError.builder().errorCode("ID101").description(ex.getMessage()).reportDateTime(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id101);

    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<PragraError> handleNoData(RuntimeException ex, WebRequest request){
        PragraError id101 = PragraError.builder().errorCode("VI-2938").description(ex.getMessage()).reportDateTime(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id101);
    }
}
