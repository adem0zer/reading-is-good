package com.adem.readingisgood.exception;

import com.adem.readingisgood.dto.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BaseRestExceptionHandler {

    @ExceptionHandler(value = {BadRequest.class})
    public ResponseEntity<ErrorMessage> processBadRequestException(final BadRequest exception) {
        ErrorMessage err = ErrorMessage.builder().setErrorMessage(exception.getMessage()).setErrorCode(400).build();
        return ResponseEntity.badRequest().body(err);
    }
}
