package com.crm.clientfieldsmanagement.producer;

import com.crm.clientfieldsmanagement.model.ClientField;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ClientFieldProducer {

    @Autowired
    private KafkaTemplate<String, String> template;

    public void sendMessage(ClientField clientField) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(clientField);
        template.send("field-created", json);
    }

}
