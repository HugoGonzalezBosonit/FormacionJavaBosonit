package com.bosonit.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class EntityNotFoundException extends Exception {
    public EntityNotFoundException (String message, int httpStatus, LocalDateTime localDateTime) {
        super("\nError: "+message+
                "\nCódigo: " +httpStatus+
                "\nHora local: " +localDateTime);
    }
}
