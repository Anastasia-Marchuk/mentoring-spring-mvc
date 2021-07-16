package com.mentoring.amarchuk.web.handler;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    public String exIndexOfBounds(Model model, IndexOutOfBoundsException ex) {
        model.addAttribute("message", ex.getMessage());
        return "error";
    }
}
