package producer;

import com.crm.clientfieldsmanagement.entity.ClientFieldEntity;
import com.crm.clientfieldsmanagement.producer.ClientFieldsProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClientFieldsProducerTest {

    private ClientFieldsProducer producerError;
    private ClientFieldsProducer producerSuccess;

    @BeforeAll
    private void init(@Mock KafkaTemplate<String, String> template) throws JsonProcessingException {
        //CONFIGURING OBJECTS
        producerError = new ClientFieldsProducer();
        producerSuccess = new ClientFieldsProducer();

        Throwable throwable = mock(Throwable.class);
        SendResult<String, Object> sendResult = mock(SendResult.class);

        //MOCK ERROR ON CALLBACK

        ListenableFuture<SendResult<String, String>> futureError = mock(ListenableFuture.class);
        when(template.send(eq("field-error"), any())).thenReturn(futureError);

        doAnswer(invocation -> {
            ListenableFutureCallback listenableFutureCallback = invocation.getArgument(0);
            listenableFutureCallback.onFailure(throwable);
            return null;
        }).when(futureError).addCallback(any(ListenableFutureCallback.class));

        ReflectionTestUtils.setField(producerError, "template", template);

        //MOCK SUCCESS ON CALLBACK

        ListenableFuture<SendResult<String, String>> futureSuccess = mock(ListenableFuture.class);
        when(template.send(eq("field-success"), any())).thenReturn(futureSuccess);

        doAnswer(invocation -> {
            ListenableFutureCallback listenableFutureCallback = invocation.getArgument(0);
            listenableFutureCallback.onSuccess(sendResult);
            return null;
        }).when(futureSuccess).addCallback(any(ListenableFutureCallback.class));

        ReflectionTestUtils.setField(producerSuccess, "template", template);

        //MOCK JSON PARSING ERROR

        ObjectMapper mapper = spy(ObjectMapper.class);
        when(mapper.writeValueAsString(eq(null))).thenThrow(new JsonProcessingException("Json Error"){});

        ReflectionTestUtils.setField(producerError, "mapper", mapper);
    }

    @Test
    public void sendMessageSuccess() {
        producerSuccess.sendMessage("success", new ClientFieldEntity());
    }

    @Test
    public void sendMessageError() {
        producerError.sendMessage("error", new ClientFieldEntity());
    }

    @Test
    public void sendMessageJsonException() {
        producerError.sendMessage("jsonError", null);
    }

}
