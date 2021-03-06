package com.crm.clientfieldsmanagement.producer;

import com.crm.clientfieldsmanagement.entity.ClientFieldEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import static org.apache.logging.log4j.LogManager.getLogger;

@Component
public class ClientFieldsProducer {

    @Autowired
    private KafkaTemplate<String, String> template;

    private final ObjectMapper mapper = new ObjectMapper();

    private static final Logger LOGGER = getLogger(ClientFieldsProducer.class.getName());

    public void sendMessage(String operation, ClientFieldEntity clientFieldEntity) {
        String json;
        try {
            json = mapper.writeValueAsString(clientFieldEntity);
        } catch (JsonProcessingException e) {
            LOGGER.error(e);
            return;
        }
        String topic = new StringBuilder("field-").append(operation).toString();

        LOGGER.info("--> SENDING MESSAGE TO KAFKA");
        ListenableFuture<SendResult<String, String>> future = template.send(topic, json);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                LOGGER.info("--> MESSAGE SENT TO KAFKA");
            }
            @Override
            public void onFailure(Throwable t) {
                LOGGER.error("--> ERROR SENDING MESSAGE KAFKA");
                LOGGER.error(t);
            }
        });

    }

}
