package config;

import com.crm.clientfieldsmanagement.config.SwaggerConfig;
import org.junit.jupiter.api.Test;

public class SwaggerConfigTest {

    private SwaggerConfig swaggerConfig = new SwaggerConfig();

    @Test
    public void api() {
        swaggerConfig.api();
    }

}
