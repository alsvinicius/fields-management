package com.crm.clientfieldsmanagement.controller;

import com.crm.clientfieldsmanagement.model.ClientField;
import com.crm.clientfieldsmanagement.service.ClientFieldsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/management/client/field")
public class ClientFieldsController {

    @Autowired
    private ClientFieldsService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<ClientField> findAll() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody ClientField create(@RequestBody ClientField field) {
        return service.create(field);
    }

    @GetMapping("/{fieldId}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ClientField findOne(@PathVariable String fieldId) {
        return service.findOne(fieldId);
    }

    @PatchMapping("/{fieldId}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ClientField update(
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
