package com.elearning.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
public class ErrorDetail {
    private LocalDateTime requestDateTime;
    private String detail;
    private String title;
    private String code;
}
