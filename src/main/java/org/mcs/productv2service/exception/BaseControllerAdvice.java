package org.mcs.productv2service.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class BaseControllerAdvice {

    @ExceptionHandler(RestException.class)
    public ResponseEntity<ErrorDto> handleException(RestException restException){
        log.warn(String.format("product with id: %d was not found", restException.getProductId()));
        ErrorDto errorDto = new ErrorDto(HttpStatus.NOT_FOUND, restException.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }
}
