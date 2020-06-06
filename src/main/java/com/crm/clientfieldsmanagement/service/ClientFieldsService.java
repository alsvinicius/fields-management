package com.crm.clientfieldsmanagement.service;

import com.crm.clientfieldsmanagement.entity.ClientFieldEntity;

import java.util.List;

public interface ClientFieldsService {
    List<ClientFieldEntity> findAll();

    ClientFieldEntity create(ClientFieldEntity field);

    ClientFieldEntity findOne(String fieldId);

    ClientFieldEntity update(String fieldId, ClientFieldEntity newField);

    void delete(String fieldId);
}
