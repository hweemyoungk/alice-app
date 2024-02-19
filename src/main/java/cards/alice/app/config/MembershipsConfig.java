package cards.alice.app.config;

import cards.alice.common.models.MembershipDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MembershipsConfig {
    @Bean
    public Map<String, MembershipDto> membershipMap() {
        final var map = new HashMap<String, MembershipDto>();
        final OffsetDateTime now = OffsetDateTime.now();

        final MembershipDto customerAlpha = MembershipDto.builder()
                .version(0)
                .displayName("customer-alpha")
                .createdDate(now)
                .lastModifiedDate(now)
                .isDeleted(Boolean.FALSE)
                .numMaxAccumulatedTotalStores(0)
                .numMaxCurrentTotalStores(0)
                .numMaxCurrentActiveStores(0)
                .numMaxAccumulatedTotalBlueprints(0)
                .numMaxCurrentTotalBlueprintsPerStore(0)
                .numMaxCurrentActiveBlueprintsPerStore(0)
                .numMaxAccumulatedTotalRedeemRules(0)
                .numMaxCurrentTotalRedeemRulesPerBlueprint(0)
                .numMaxAccumulatedTotalCards(-1)
                .numMaxCurrentTotalCards(-1)
                .numMaxCurrentActiveCards(-1)
                .build();
        map.put(customerAlpha.getDisplayName(), customerAlpha);

        final MembershipDto ownerAlpha = MembershipDto.builder()
                .version(0)
                .displayName("owner-alpha")
                .createdDate(now)
                .lastModifiedDate(now)
                .isDeleted(Boolean.FALSE)
                .numMaxAccumulatedTotalStores(-1)
                .numMaxCurrentTotalStores(2)
                .numMaxCurrentActiveStores(1)
                .numMaxAccumulatedTotalBlueprints(-1)
                .numMaxCurrentTotalBlueprintsPerStore(3)
                .numMaxCurrentActiveBlueprintsPerStore(3)
                .numMaxAccumulatedTotalRedeemRules(-1)
                .numMaxCurrentTotalRedeemRulesPerBlueprint(3)
                .numMaxAccumulatedTotalCards(0)
                .numMaxCurrentTotalCards(0)
                .numMaxCurrentActiveCards(0)
                .build();
        map.put(ownerAlpha.getDisplayName(), ownerAlpha);

        return map;
    }
}
