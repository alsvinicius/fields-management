package entity;

import com.crm.clientfieldsmanagement.entity.ClientFieldEntity;
import org.junit.jupiter.api.Test;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

public class ClientFieldEntityTest {

    @Test
    public void ClientFieldEntity() {
        assertPojoMethodsFor(ClientFieldEntity.class)
                .testing(Method.CONSTRUCTOR, Method.GETTER, Method.SETTER)
                .areWellImplemented();
    }

    @Test
    public void ClientFieldBuilder() {
        assertPojoMethodsFor(new ClientFieldEntity().builder().getClass())
                .testing(Method.CONSTRUCTOR)
                .areWellImplemented();
    }

}
