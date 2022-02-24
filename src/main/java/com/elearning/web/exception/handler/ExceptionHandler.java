package com.elearning.web.exception.handler;

import com.elearning.dto.ErrorDetail;
import com.elearning.web.exception.exceptions.InvalidFieldException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({InvalidFieldException.class})
    @ResponseBody
    public ResponseEntity<Object> handleInvalidFieldException(InvalidFieldException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorDetail apiError = ErrorDetail.builder().requestDateTime(LocalDateTime.now().toString()).code(status.toString()).detail(ex.getMessage()).build();
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), status, request);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({RuntimeException.class})
    @ResponseBody
    public ResponseEntity<Object> handleError500(RuntimeException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorDetail apiError = ErrorDetail.builder().requestDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))).code(status.toString()).detail(ex.getMessage()).build();
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), status, request);
    }
}
