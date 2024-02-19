package cards.alice.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MinRequirementsConfig {
    @Bean
    public Map<String, String> minRequirements(
            @Value("${cards.alice.app.minVersionName}") String minVersionName) {
        final var minRequirements = new HashMap<String, String>();

        minRequirements.put("minVersionName", minVersionName);
        return minRequirements;
    }
}
