package com.crm.clientfieldsmanagement.controller;

import com.crm.clientfieldsmanagement.dto.ClientFieldDTO;
import com.crm.clientfieldsmanagement.entity.ClientFieldEntity;
import com.crm.clientfieldsmanagement.service.ClientFieldsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    List<ClientFieldEntity> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{fieldId}", produces = RESPONSE_TYPE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    ClientFieldEntity findOne(@PathVariable String fieldId) {
        return service.findOne(fieldId);
    }

    @PostMapping(produces = RESPONSE_TYPE)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    ClientFieldEntity create(@RequestBody ClientFieldDTO field) {
        return service.create(field);
    }

    @PatchMapping(value = "/{fieldId}", produces = RESPONSE_TYPE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    ClientFieldEntity update(
            @PathVariable String fieldId,
            @RequestBody ClientFieldDTO field
    ) {
        return service.update(fieldId, field);
    }

    @DeleteMapping("/{fieldId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String fieldId) {
        service.delete(fieldId);
    }


}
