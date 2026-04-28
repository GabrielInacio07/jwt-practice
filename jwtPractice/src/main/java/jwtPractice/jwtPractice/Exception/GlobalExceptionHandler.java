package jwtPractice.jwtPractice.Exception;

import jwtPractice.jwtPractice.DTOs.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> illegalArgument(IllegalArgumentException exception){

        ErrorDTO dto = ErrorDTO.builder()
                .code(400)
                .message("BAD_REQUEST")
                .details(exception.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }
}
