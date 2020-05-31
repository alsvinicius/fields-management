package com.crm.clientfieldsmanagement.repository;

import com.crm.clientfieldsmanagement.model.ClientField;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientFieldsRepository extends MongoRepository<ClientField, String> {
}
