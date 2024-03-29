package com.code.sales.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Error Response for application when some exception occurs
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String error;

}
