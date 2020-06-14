package com.crm.clientfieldsmanagement.repository;


import com.crm.clientfieldsmanagement.entity.FieldNotificationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FieldNotificationRepository extends MongoRepository<FieldNotificationEntity, String> {
}
