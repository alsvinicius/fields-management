package controller.advice;

import com.crm.clientfieldsmanagement.controller.advice.ClientFieldsNotFoundAdvice;
import com.crm.clientfieldsmanagement.exception.ClientFieldNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientFieldsNotFoundAdviceTest {

    private ClientFieldsNotFoundAdvice advice = new ClientFieldsNotFoundAdvice();

    @Test
    public void notFoundHandler() {
        ClientFieldNotFoundException exception = new ClientFieldNotFoundException("123");
        String message = advice.notFoundHandler(exception);
        assertEquals("Client field with id 123 not found", message);
    }

}
