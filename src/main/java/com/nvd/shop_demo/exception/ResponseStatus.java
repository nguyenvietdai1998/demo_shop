package com.nvd.shop_demo.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class ResponseStatus {
    private final String code;
    private final String message;
    private final HttpStatus httpCode;

}
