package br.com.mayara.HogwartsSortingHat.config;

import br.com.mayara.HogwartsSortingHat.dto.ErrorDTO;
import br.com.mayara.HogwartsSortingHat.exception.HouseNotFoundException;
import br.com.mayara.HogwartsSortingHat.exception.SchoolNotFoundException;
import br.com.mayara.HogwartsSortingHat.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandlerException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(StudentNotFoundException.class)
    public ErrorDTO handlerStudentNotFound(StudentNotFoundException ex) {
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HouseNotFoundException.class)
    public ErrorDTO handlerHouseNotFound(HouseNotFoundException ex) {
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(SchoolNotFoundException.class)
    public ErrorDTO handlerSchoolNotFound(SchoolNotFoundException ex) {
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }




}
