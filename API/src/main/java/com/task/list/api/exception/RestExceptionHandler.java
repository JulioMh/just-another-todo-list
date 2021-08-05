package com.task.list.api.exception;

import com.task.list.api.dto.error.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildResponseEntity(
                new ApiError(HttpStatus.BAD_REQUEST, "Malformed JSON request", ex)
        );
    }

    @ExceptionHandler(Throwable.class)
    protected ResponseEntity<Object> handleThrowableException(Throwable ex) {
        return buildResponseEntity(
                new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex)
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintValidation(ConstraintViolationException ex){
        return buildResponseEntity(
                new ApiError(HttpStatus.BAD_REQUEST, "Validation error", ex)
        );
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleNotFoundException(EntityNotFoundException ex){
        return buildResponseEntity(
                new ApiError(HttpStatus.NOT_FOUND, "Entity not found", ex)
        );
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
