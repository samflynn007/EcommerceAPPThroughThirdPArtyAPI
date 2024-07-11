package dev.venky.productservice.exceptions;

import dev.venky.productservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvices {

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException notFoundException) {
        System.out.println("Not Found exception happened");
        return new ResponseEntity(
                new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}
