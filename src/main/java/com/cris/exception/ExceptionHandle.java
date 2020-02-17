package com.cris.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Component
public class ExceptionHandle {
    @ExceptionHandler(UnauthorizedException.class)
    public String handleUnauthorizedException() {
        return "403";
    }
}
