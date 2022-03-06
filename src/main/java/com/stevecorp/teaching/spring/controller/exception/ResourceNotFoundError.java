package com.stevecorp.teaching.spring.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResourceNotFoundError {

    private String errorMessage;

}
