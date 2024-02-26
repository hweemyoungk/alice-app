package cards.alice.common.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import java.time.OffsetDateTime;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppNoticeDto extends LongDto {
    /**
     * The higher the priority is, the earlier notice pops up in Carol.<br>
     * Can be duplicate across notices.
     */
    @NotNull
    @Positive
    @Builder.Default
    private Integer priority = 1;
    @NotBlank
    @Length(max = 1000)
    private String description;
    @NotNull
    private Boolean canSuppress;
    @NotNull
    private Boolean isSuppressed;

    private OffsetDateTime expirationDate;
    private String url;
}
