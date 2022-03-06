package com.stevecorp.teaching.spring.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ValidationError {

    private String description;
    private String fieldName;
    private String reason;

}