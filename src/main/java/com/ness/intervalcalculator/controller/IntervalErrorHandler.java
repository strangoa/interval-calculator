package com.ness.intervalcalculator.controller;

import com.ness.intervalcalculator.dto.ApiResponse;
import com.ness.intervalcalculator.exception.IntervalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Error handler for IntervalException and for other exceptions.
 */
@ControllerAdvice
@Slf4j
public class IntervalErrorHandler extends ResponseEntityExceptionHandler {

    /**
     * Handles IntervalExceptions.
     *
     * @param e
     * @return
     */
    @ExceptionHandler(IntervalException.class)
    public ResponseEntity<ApiResponse> handleIntervalException(IntervalException e) {
        ApiResponse response = ApiResponse.builder()
                .success(false)
                .errorMessage(e.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles other exception types.
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleExceptions(Exception e) {
        ApiResponse response = ApiResponse.builder()
                .success(false)
                .errorMessage(e.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
