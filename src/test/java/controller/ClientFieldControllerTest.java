package controller;

import com.crm.clientfieldsmanagement.controller.ClientFieldsController;
import com.crm.clientfieldsmanagement.dto.ClientFieldDTO;
import com.crm.clientfieldsmanagement.entity.ClientFieldEntity;
import com.crm.clientfieldsmanagement.service.ClientFieldsService;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.ArrayList;
import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.booleanThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClientFieldControllerTest {

    private ClientFieldsController controller;

    private PodamFactory factory = new PodamFactoryImpl();

    private ClientFieldDTO fieldDTO;
    private ClientFieldEntity fieldEntity;
    private List<ClientFieldEntity> fieldList;

    @BeforeAll
    public void init(@Mock ClientFieldsService service) {
        controller = new ClientFieldsController();

        fieldDTO = factory.manufacturePojo(ClientFieldDTO.class);
        fieldEntity = factory.manufacturePojo(ClientFieldEntity.class);
        fieldEntity.setIdField(fieldDTO.getIdField());

        fieldList = factory.manufacturePojo(ArrayList.class, ClientFieldEntity.class);

        when(service.findAll()).thenReturn(fieldList);
        when(service.findOne(any())).thenReturn(fieldEntity);
        when(service.create(any())).thenReturn(fieldEntity);
        when(service.update(any(), any())).thenReturn(fieldEntity);

        doNothing().when(service).delete(any());

        ReflectionTestUtils.setField(controller, "service", service);
    }

    @Test
    public void findAll() {
        assertEquals(fieldList, controller.findAll());
    }

    @Test
    public void findOne() {
        assertEquals(fieldEntity, controller.findOne("123"));
    }

    @Test
    public void create() {
        assertEquals(fieldEntity.getIdField(), controller.create(fieldDTO).getIdField());
    }

    @Test
    public void update() {
        assertEquals(fieldEntity.getIdField(), controller.update("123", fieldDTO).getIdField());
    }

    @Test
    public void delete() {
        controller.delete("123");
    }


}
