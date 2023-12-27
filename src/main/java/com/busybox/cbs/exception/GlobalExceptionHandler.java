package com.busybox.cbs.exception;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.busybox.cbs.util.ResponseHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        
        String detailedMessage = ex.getMostSpecificCause().getMessage();
       return ResponseHandler.generateResponseForMessageandstatus("JSON parse error: " + detailedMessage, "failure");
    }

}
