package com.crm.clientfieldsmanagement.controller;

import com.crm.clientfieldsmanagement.dto.ClientFieldDTO;
import com.crm.clientfieldsmanagement.entity.ClientFieldEntity;
import com.crm.clientfieldsmanagement.entity.FieldNotificationEntity;
import com.crm.clientfieldsmanagement.service.ClientFieldsService;
import com.crm.clientfieldsmanagement.service.FieldNotificationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notification/client/field")
@Api(tags = "Fields Notifications", produces = "application/json")
public class FieldNotificationController {

    @Autowired
    private FieldNotificationService service;

    private static final String RESPONSE_TYPE = "application/json";

    @GetMapping(produces = RESPONSE_TYPE)
    @CrossOrigin(origins = "*", allowCredentials = "true")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<FieldNotificationEntity> findAll() {
        return service.findAll();
    }

}
