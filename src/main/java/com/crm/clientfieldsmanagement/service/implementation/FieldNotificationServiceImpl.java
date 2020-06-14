package com.crm.clientfieldsmanagement.service.implementation;

import com.crm.clientfieldsmanagement.entity.FieldNotificationEntity;
import com.crm.clientfieldsmanagement.repository.FieldNotificationRepository;
import com.crm.clientfieldsmanagement.service.FieldNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldNotificationServiceImpl implements FieldNotificationService {

    @Autowired
    private FieldNotificationRepository repository;

    public List<FieldNotificationEntity> findAll() {
        return repository.findAll();
    }
}
