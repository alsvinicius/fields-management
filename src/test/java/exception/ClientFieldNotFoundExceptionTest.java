package exception;

import com.crm.clientfieldsmanagement.exception.ClientFieldNotFoundException;
import org.junit.jupiter.api.Test;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

public class ClientFieldNotFoundExceptionTest {

    @Test
    public void ClientFieldNotFoundException() {
        assertPojoMethodsFor(ClientFieldNotFoundException.class)
                .testing(Method.CONSTRUCTOR)
                .areWellImplemented();
    }

}
