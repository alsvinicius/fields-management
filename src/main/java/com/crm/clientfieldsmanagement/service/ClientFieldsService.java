package com.crm.clientfieldsmanagement.service;

import com.crm.clientfieldsmanagement.exception.ClientFieldNotFoundException;
import com.crm.clientfieldsmanagement.model.ClientField;
import com.crm.clientfieldsmanagement.producer.ClientFieldsProducer;
import com.crm.clientfieldsmanagement.repository.ClientFieldsRepository;
import com.crm.clientfieldsmanagement.util.POJOUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;

@Service
public class ClientFieldsService {

    @Autowired
    private ClientFieldsRepository repository;

    @Autowired
    private ClientFieldsProducer producer;

    private static final Logger LOGGER = getLogger(ClientFieldsService.class.getName());

    public List<ClientField> findAll() {
        return repository.findAll();
    }

    public ClientField create(ClientField field) {
        ClientField created = repository.save(field);

        if (created.getIdField() != null) {
            producer.sendMessage("created", created);
        }

        return created;
    }

    public ClientField findOne(String fieldId) {
        return repository
                .findById(fieldId)
                .orElseThrow(() -> new ClientFieldNotFoundException(fieldId));
    }

    public ClientField update(String fieldId, ClientField newField) {
        ClientField field = findOne(fieldId);
        BeanUtils.copyProperties(newField, field, POJOUtils.getNullPropertyNames(newField));
        ClientField saved = repository.save(field);
        producer.sendMessage("updated", saved);

        return saved;
    }

    public void delete(String fieldId) {
        ClientField field = findOne(fieldId);
        repository.delete(field);
        producer.sendMessage("deleted", field);
    }
}
