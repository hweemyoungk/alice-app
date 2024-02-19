package cards.alice.common.models;

import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.SuperBuilder;

// Just general detail of membership. Not allocated per user.
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class MembershipDto extends LongDto {
    // Monolith service picks the highest membership among candidates.
    // Must be unique across the same class
    @Positive
    @Builder.Default
    private Integer priority = 1;
}
