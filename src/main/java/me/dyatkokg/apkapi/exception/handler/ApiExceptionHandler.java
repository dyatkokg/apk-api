package me.dyatkokg.apkapi.exception.handler;

import lombok.extern.slf4j.Slf4j;
import me.dyatkokg.apkapi.exception.FileWithNameAndVersionAlreadyExistException;
import me.dyatkokg.apkapi.exception.IncorrectFileTypeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler {

    @ExceptionHandler({FileWithNameAndVersionAlreadyExistException.class, IncorrectFileTypeException.class})
    public ResponseEntity<?> handleException(RuntimeException e) {
        log.info("{}", e.getMessage());
        return ResponseEntity.badRequest().body(Collections.singletonMap("exception", e.getMessage()));
    }

}
