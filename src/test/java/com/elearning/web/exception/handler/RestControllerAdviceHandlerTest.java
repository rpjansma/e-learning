package com.elearning.web.exception.handler;

import com.elearning.dto.ErrorDetail;
import com.elearning.web.exception.exceptions.InternalServerErrorException;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class RestControllerAdviceHandlerTest {

    RestControllerAdviceHandler adviceHandler = new RestControllerAdviceHandler();
    WebRequest request = mock(WebRequest.class);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void handleInternalServerError() {
        InternalServerErrorException ex = new InternalServerErrorException("Teste");
        ResponseEntity<Object> response = adviceHandler.handleInternalServerError(ex, request);
        testHandleException(response, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @Test
    void handleInvalidFieldException() {
    }

    @Test
    void handleUncaught() {
    }

    private void testHandleException(ResponseEntity<Object> response, HttpStatus status, String detailMessage) {
        ErrorDetail errorDetail = (ErrorDetail) response.getBody();
        assertEquals(response.getStatusCode(), Matchers.equalTo(status));
        assertEquals(errorDetail.getDetail(), Matchers.equalTo(detailMessage));
    }
}