package com.practice.websocketpractice.exception.payload;

import java.time.Instant;

public record ExceptionResponse(int status, String reason, Instant timestamp) {
    
}
