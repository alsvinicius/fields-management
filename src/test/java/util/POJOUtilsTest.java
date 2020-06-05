package util;

import com.crm.clientfieldsmanagement.dto.ClientFieldDTO;
import com.crm.clientfieldsmanagement.util.POJOUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class POJOUtilsTest {

    @Test
    public void getNullPropertyNames() {
        assertNotNull(POJOUtils.getNullPropertyNames(new ClientFieldDTO()));
    }

}
