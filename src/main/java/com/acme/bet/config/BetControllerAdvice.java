package com.acme.bet.config;

import com.acme.bet.dto.ExceptionalResponse;
import com.acme.bet.exception.GameException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class BetControllerAdvice {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Constraint violation exception")
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void handleConstraintViolationExceptionResponse() {
        log.error("Constraint violation exception is invoked bad response will be returned to the client");
    }

    @ExceptionHandler(GameException.class)
    public ResponseEntity<ExceptionalResponse> baseExceptionHandle(GameException exception) {
        return new ResponseEntity<>(new ExceptionalResponse(exception.getCode(), exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
