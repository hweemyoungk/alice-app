package cards.alice.common.models;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

// Just general detail of membership. Not allocated per user.
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMembershipDto extends MembershipDto {
    // -1 means infinite
    @Min(-1)
    private Integer numMaxAccumulatedTotalCards;
    @Min(-1)
    private Integer numMaxCurrentTotalCards;
    @Min(-1)
    private Integer numMaxCurrentActiveCards;
}
