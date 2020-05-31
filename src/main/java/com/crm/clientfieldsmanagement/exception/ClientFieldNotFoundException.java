package com.crm.clientfieldsmanagement.exception;

public class ClientFieldNotFoundException extends RuntimeException {

    public ClientFieldNotFoundException(String fieldId) {
        super(new StringBuilder("Client field with id ")
                .append(fieldId)
                .append(" not found")
                .toString());
    }

}
