package com.crm.clientfieldsmanagement.controller.advice;

import com.crm.clientfieldsmanagement.exception.ClientFieldNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    String notFoundHandler(Exception ex) {
        return "Erro inesperado " + ex.getMessage();
    }

}
