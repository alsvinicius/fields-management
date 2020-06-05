package com.crm.clientfieldsmanagement.service;

import com.crm.clientfieldsmanagement.entity.ClientFieldEntity;
import com.crm.clientfieldsmanagement.exception.ClientFieldNotFoundException;
import com.crm.clientfieldsmanagement.producer.ClientFieldsProducer;
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

    @Autowired
    private ClientFieldsProducer producer;

    public List<ClientFieldEntity> findAll() {
        return repository.findAll();
    }

    public ClientFieldEntity create(ClientFieldEntity field) {
        ClientFieldEntity created = repository.save(field);

        if (created.getIdField() != null) {
            producer.sendMessage("created", created);
        }

        return created;
    }

    public ClientFieldEntity findOne(String fieldId) {
        return repository
                .findById(fieldId)
                .orElseThrow(() -> new ClientFieldNotFoundException(fieldId));
    }

    public ClientFieldEntity update(String fieldId, ClientFieldEntity newField) {
        ClientFieldEntity field = findOne(fieldId);
        BeanUtils.copyProperties(newField, field, POJOUtils.getNullPropertyNames(newField));
        ClientFieldEntity saved = repository.save(field);
        producer.sendMessage("updated", saved);

        return saved;
    }

    public void delete(String fieldId) {
        ClientFieldEntity field = findOne(fieldId);
        repository.delete(field);
        producer.sendMessage("deleted", field);
    }
}
