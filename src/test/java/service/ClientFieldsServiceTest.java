package service;

import com.crm.clientfieldsmanagement.controller.ClientFieldsController;
import com.crm.clientfieldsmanagement.dto.ClientFieldDTO;
import com.crm.clientfieldsmanagement.entity.ClientFieldEntity;
import com.crm.clientfieldsmanagement.producer.ClientFieldsProducer;
import com.crm.clientfieldsmanagement.repository.ClientFieldsRepository;
import com.crm.clientfieldsmanagement.service.ClientFieldsService;
import jdk.nashorn.internal.runtime.options.Option;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClientFieldsServiceTest {

    private ClientFieldsService service;

    private PodamFactory factory = new PodamFactoryImpl();

    private ClientFieldEntity fieldEntity;
    private List<ClientFieldEntity> fieldList;

    @BeforeAll
    public void init(
            @Mock ClientFieldsRepository repository,
            @Mock ClientFieldsProducer producer
    ) {
        this.service = new ClientFieldsService();

        fieldEntity = factory.manufacturePojo(ClientFieldEntity.class);
        fieldList = factory.manufacturePojo(ArrayList.class, ClientFieldEntity.class);

        when(repository.findAll()).thenReturn(fieldList);
        when(repository.findById(any())).thenReturn(Optional.of(fieldEntity));
        when(repository.save(any())).thenReturn(fieldEntity);
        when(repository.save(any())).thenReturn(fieldEntity);

        doNothing().when(repository).delete(any());
        doNothing().when(producer).sendMessage(any(),any());

        ReflectionTestUtils.setField(this.service, "repository", repository);
        ReflectionTestUtils.setField(this.service, "producer", producer);
    }

    @Test
    public void findAll() {
        assertEquals(fieldList, service.findAll());
    }

    @Test
    public void findOne() {
        assertEquals(fieldEntity, service.findOne("123"));
    }

    @Test
    public void create() {
        assertEquals(fieldEntity.getIdField(), service.create(fieldEntity).getIdField());
    }

    @Test
    public void update() {
        assertEquals(fieldEntity.getIdField(), service.update("123", fieldEntity).getIdField());
    }

    @Test
    public void delete() {
        service.delete("123");
    }

}
