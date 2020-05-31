package com.crm.clientfieldsmanagement.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("field")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class ClientField {

    @Id
    private String idField;
    private String name;
    private Boolean required;
    private long length;
    private String maskRegex;
    private String placeholder;
    private int position;

}
