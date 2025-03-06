package com.kylas.ParkingLot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(ParkingLotException.class)
        public ResponseEntity<Map<String, String>> handleParkingLotException(ParkingLotException ex) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("errorCode", ex.getErrorResource().getErrorCode());
            errorResponse.put("message", ex.getErrorResource().getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

