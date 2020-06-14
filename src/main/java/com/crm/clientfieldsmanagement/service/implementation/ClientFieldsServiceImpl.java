package com.crm.clientfieldsmanagement.service.implementation;

import com.crm.clientfieldsmanagement.entity.ClientFieldEntity;
import com.crm.clientfieldsmanagement.exception.ClientFieldNotFoundException;
import com.crm.clientfieldsmanagement.producer.ClientFieldsProducer;
import com.crm.clientfieldsmanagement.repository.ClientFieldsRepository;
import com.crm.clientfieldsmanagement.service.ClientFieldsService;
import com.crm.clientfieldsmanagement.util.POJOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientFieldsServiceImpl implements ClientFieldsService {

    @Autowired
    private ClientFieldsRepository repository;

    @Autowired
    private ClientFieldsProducer producer;

    @Override
    public List<ClientFieldEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public ClientFieldEntity create(ClientFieldEntity field) {
        ClientFieldEntity created = repository.save(field);

        if (created.getIdField() != null) {
            producer.sendMessage("created", created);
        }

        return created;
    }

    @Override
    public ClientFieldEntity findOne(String fieldId) {
        return repository
                .findById(fieldId)
                .orElseThrow(() -> new ClientFieldNotFoundException(fieldId));
    }

    @Override
    public ClientFieldEntity update(String fieldId, ClientFieldEntity newField) {
        ClientFieldEntity field = findOne(fieldId);
        BeanUtils.copyProperties(newField, field, POJOUtils.getNullPropertyNames(newField));
        ClientFieldEntity saved = repository.save(field);
        producer.sendMessage("updated", saved);

        return saved;
    }

    @Override
    public void delete(String fieldId) {
        ClientFieldEntity field = findOne(fieldId);
        repository.delete(field);
        producer.sendMessage("deleted", field);
    }
}
