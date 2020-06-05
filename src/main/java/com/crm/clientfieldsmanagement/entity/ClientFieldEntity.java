package com.crm.clientfieldsmanagement.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("field")
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class ClientFieldEntity {

    @Id
    private String idField;
    private String name;
    private Boolean required;
    private Long length;
    private String maskRegex;
    private String placeholder;
    private Integer position;

}
