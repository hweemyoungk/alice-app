package cards.alice.app.config;

import cards.alice.common.models.AppNoticeDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.OffsetDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Configuration
public class AppNoticesConfig {
    private final OffsetDateTime now = OffsetDateTime.now();

    @Bean
    public Map<Long, AppNoticeDto> appNoticeMap() {
        final var map = new LinkedHashMap<Long, AppNoticeDto>();

        final AppNoticeDto firstAppNotice = AppNoticeDto.builder()
                .id(1L)
                .createdDate(now)
                .lastModifiedDate(now)
                .isDeleted(Boolean.FALSE)
                .displayName("Welcome to Carol Cards!")
                .description("Congratulations!\nYou are the recipient of the very first notice!\nThis notice cannot be suppressed.")
                .canSuppress(Boolean.FALSE)
                .isSuppressed(Boolean.FALSE)
                .expirationDate(null)
                .url("https://carol.cards/public/private-policy")
                .build();
        map.put(firstAppNotice.getId(), firstAppNotice);

        final AppNoticeDto secondAppNotice = AppNoticeDto.builder()
                .id(2L)
                .createdDate(now)
                .lastModifiedDate(now)
                .isDeleted(Boolean.FALSE)
                .displayName("Server maintenance plan")
                .priority(2)
                .description("Server going down for March 2~3, 2024 (KST).")
                .canSuppress(Boolean.TRUE)
                .isSuppressed(Boolean.FALSE)
                .expirationDate(now
                        .withYear(2024)
                        .withMonth(3)
                        .withDayOfMonth(4)
                        .withHour(0)
                        .withMinute(0)
                        .withSecond(0))
                .build();
        map.put(secondAppNotice.getId(), secondAppNotice);

        return map;
    }

    @Bean
    public AtomicLong appNoticeIdManager(Map<Long, AppNoticeDto> appNoticeMap) {
        return new AtomicLong(appNoticeMap.size());
    }
}
