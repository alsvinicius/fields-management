package com.crm.clientfieldsmanagement.dto;

import com.crm.clientfieldsmanagement.entity.ClientFieldEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class ClientFieldDTO extends ClientFieldEntity {

}
