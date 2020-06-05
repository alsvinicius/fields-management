package com.crm.clientfieldsmanagement.controller;

import com.crm.clientfieldsmanagement.model.ClientField;
import com.crm.clientfieldsmanagement.service.ClientFieldsService;
import com.sun.org.apache.xpath.internal.objects.XString;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/management/client/field")
@Api(tags = "Client Fields", produces = "application/json")
public class ClientFieldsController {

    @Autowired
    private ClientFieldsService service;

    private static final String RESPONSE_TYPE = "application/json";

    @GetMapping(produces = RESPONSE_TYPE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<ClientField> findAll() {
        return service.findAll();
    }

    @PostMapping(produces = RESPONSE_TYPE)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    ClientField create(@RequestBody ClientField field) {
        return service.create(field);
    }

    @GetMapping(value = "/{fieldId}", produces = RESPONSE_TYPE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    ClientField findOne(@PathVariable String fieldId) {
        return service.findOne(fieldId);
    }

    @PatchMapping(value = "/{fieldId}", produces = RESPONSE_TYPE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    ClientField update(
            @PathVariable String fieldId,
            @RequestBody ClientField field
    ) {
        return service.update(fieldId, field);
    }

    @DeleteMapping("/{fieldId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String fieldId) {
        service.delete(fieldId);
    }


}
