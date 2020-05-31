package com.crm.clientfieldsmanagement.service;

import com.crm.clientfieldsmanagement.exception.ClientFieldNotFoundException;
import com.crm.clientfieldsmanagement.model.ClientField;
import com.crm.clientfieldsmanagement.repository.ClientFieldsRepository;
import com.crm.clientfieldsmanagement.util.POJOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientFieldsService {

    @Autowired
    private ClientFieldsRepository repository;

    public List<ClientField> findAll() {
        return repository.findAll();
    }

    public ClientField create(ClientField field) {
        return repository.save(field);
    }

    public ClientField findOne(String fieldId) {
        return repository
                .findById(fieldId)
                .orElseThrow(() -> new ClientFieldNotFoundException(fieldId));
    }

    public ClientField update(String fieldId, ClientField newField) {
        ClientField field = findOne(fieldId);
        BeanUtils.copyProperties(newField, field, POJOUtils.getNullPropertyNames(newField));
        return repository.save(field);
    }

    public void delete(String fieldId) {
        repository.delete(findOne(fieldId));
    }
}
