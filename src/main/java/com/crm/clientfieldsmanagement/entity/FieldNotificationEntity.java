package com.crm.clientfieldsmanagement.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("field_notification")
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class FieldNotificationEntity {

    @Id
    private String idNotification;
    private String fieldName;
    private String operation;

}
