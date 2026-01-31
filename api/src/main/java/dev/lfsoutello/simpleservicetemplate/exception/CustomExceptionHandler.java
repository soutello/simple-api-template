package dev.lfsoutello.simpleservicetemplate.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    public static final Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Void> handleUnknownException(Exception e) {
        log.info("m=handleUnknownException", e);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ExampleNotFoundException.class)
    protected ResponseEntity<Void> handleExampleNotFoundException(ExampleNotFoundException e) {
        log.info("m=handleExampleNotFoundException", e);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
