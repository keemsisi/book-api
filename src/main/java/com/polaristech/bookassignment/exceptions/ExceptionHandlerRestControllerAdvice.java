package com.polaristech.bookassignment.exceptions;

import org.hibernate.exception.SQLGrammarException;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerRestControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class, JpaSystemException.class})
    protected ResponseEntity<Object> badRequests(RuntimeException ex, WebRequest request) {
        ex.printStackTrace();
        String bodyOfResponse = ex.getMessage();
        return ResponseEntity.badRequest().body(Map.of(
                "message", "exception occurred",
                "status", 400,
                "timestamp", new Date(),
                "data", "{}"));
    }

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    protected ResponseEntity<Object> resourceNotFound(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return ResponseEntity.badRequest().body(Map.of(
                "message", ex.getMessage(),
                "status", 400,
                "timestamp", new Date(),
                "data", "{}"));
    }

    @ExceptionHandler(value = {SQLGrammarException.class, Exception.class})
    protected ResponseEntity<Object> serverError(RuntimeException ex, WebRequest request) {
        ex.printStackTrace();
        String bodyOfResponse = ex.getMessage();
        return ResponseEntity.status(500).body(Map.of(
                "message", "internal server error occurred",
                "status", 500,
                "timestamp", new Date(),
                "data", "{}"));
    }
}