package com.assetflow.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<?> notFound(ResourceNotFoundException e) { return response(HttpStatus.NOT_FOUND, e.getMessage()); }
    @ExceptionHandler({IllegalArgumentException.class, DataIntegrityViolationException.class})
    ResponseEntity<?> badRequest(Exception e) { return response(HttpStatus.BAD_REQUEST, "The request could not be saved. Check required and unique fields."); }
    @ExceptionHandler(Exception.class)
    ResponseEntity<?> unexpected(Exception e) { return response(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected server error."); }
    private ResponseEntity<?> response(HttpStatus status, String message) { return ResponseEntity.status(status).body(Map.of("timestamp", Instant.now(), "status", status.value(), "message", message)); }
}
