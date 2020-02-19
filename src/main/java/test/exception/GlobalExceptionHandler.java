package test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = GlobalRequestException.class)
    public ResponseEntity<Object> handleGlobalRequestException(GlobalRequestException e) {
        GlobalException globalException = new GlobalException(
                e.getMessage(),
                e,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(globalException, HttpStatus.BAD_REQUEST);
    }
}
