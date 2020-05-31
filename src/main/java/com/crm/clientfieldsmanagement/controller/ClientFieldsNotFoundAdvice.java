package com.crm.clientfieldsmanagement.controller;

import com.crm.clientfieldsmanagement.exception.ClientFieldNotFoundException;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ClientFieldsNotFoundAdvice {

    @ExceptionHandler(ClientFieldNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody String notFoundHandler(ClientFieldNotFoundException ex) {
        return ex.getMessage();
    }

}
