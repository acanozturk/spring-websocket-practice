package com.practice.websocketpractice.exception.handler;

import com.practice.websocketpractice.exception.NotFoundException;
import com.practice.websocketpractice.exception.payload.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Instant;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handle(final NotFoundException exception) {
        log.error("{} occurred: ", exception.getClass().getSimpleName(), exception);

        return new ExceptionResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                Instant.now()
        );
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handle(final NullPointerException exception) {
        log.error("{} occurred: ", exception.getClass().getSimpleName(), exception);

        return new ExceptionResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage(),
                Instant.now()
        );
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handle(final RuntimeException exception) {
        log.error("{} occurred: ", exception.getClass().getSimpleName(), exception);

        return new ExceptionResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage(),
                Instant.now()
        );
    }

}
