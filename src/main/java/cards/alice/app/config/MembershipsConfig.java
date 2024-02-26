package cards.alice.app.config;

import cards.alice.common.models.CustomerMembershipDto;
import cards.alice.common.models.OwnerMembershipDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MembershipsConfig {
    private final OffsetDateTime now = OffsetDateTime.now();

    @Bean
    public Map<String, CustomerMembershipDto> customerMembershipMap() {
        final var map = new HashMap<String, CustomerMembershipDto>();

        final CustomerMembershipDto customerAlpha = CustomerMembershipDto.builder()
                .version(0)
                .displayName("customer-alpha")
                .createdDate(now)
                .lastModifiedDate(now)
                .isDeleted(Boolean.FALSE)
                .priority(1)
                .numMaxAccumulatedTotalCards(-1)
                .numMaxCurrentTotalCards(-1)
                .numMaxCurrentActiveCards(-1)
                .build();

        map.put(customerAlpha.getDisplayName(), customerAlpha);

        return map;
    }

    @Bean
    public Map<String, OwnerMembershipDto> ownerMembershipMap() {
        final var map = new HashMap<String, OwnerMembershipDto>();

        final OwnerMembershipDto ownerAlpha = OwnerMembershipDto.builder()
                .version(0)
                .displayName("owner-alpha")
                .createdDate(now)
                .lastModifiedDate(now)
                .isDeleted(Boolean.FALSE)
                .priority(1)
                .numMaxAccumulatedTotalStores(-1)
                .numMaxCurrentTotalStores(2)
                .numMaxCurrentActiveStores(1)
                .numMaxCurrentTotalBlueprintsPerStore(3)
                .numMaxCurrentActiveBlueprintsPerStore(3)
                .numMaxCurrentTotalRedeemRulesPerBlueprint(3)
                .numMaxCurrentActiveRedeemRulesPerBlueprint(3)
                .build();
        map.put(ownerAlpha.getDisplayName(), ownerAlpha);

        return map;
    }
}
