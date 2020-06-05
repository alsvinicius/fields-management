package config;

import com.crm.clientfieldsmanagement.config.WebConfig;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

public class WebConfigTest {

    private WebConfig webConfig = new WebConfig();

    @Test
    public void addCorsMappings() {
        webConfig.addCorsMappings(new CorsRegistry());
    }

}
