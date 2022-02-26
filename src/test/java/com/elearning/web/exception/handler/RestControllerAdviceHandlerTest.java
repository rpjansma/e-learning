package com.elearning.web.exception.handler;

import com.elearning.dto.ErrorDetail;
import com.elearning.web.exception.exceptions.InternalServerErrorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class RestControllerAdviceHandlerTest {

    RestControllerAdviceHandler adviceHandler;
    InternalServerErrorException internalServerErrorException;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        adviceHandler = new RestControllerAdviceHandler();
    }

    @Test
    void handleInternalServerError() {
        InternalServerErrorException ex = new InternalServerErrorException("Teste");
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorDetail apiError = ErrorDetail.builder().requestDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))).code(status.toString()).title(ex.getMessage()).detail(ex.getCause().toString()).build();
        adviceHandler.handleInternalServerError(ex, apiError, new HttpHeaders(), status, request);
    }

    @Test
    void handleInvalidFieldException() {
    }

    @Test
    void handleUncaught() {
    }
}