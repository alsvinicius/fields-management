package com.crm.clientfieldsmanagement.repository;

import com.crm.clientfieldsmanagement.entity.ClientFieldEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientFieldsRepository extends MongoRepository<ClientFieldEntity, String> {
}
