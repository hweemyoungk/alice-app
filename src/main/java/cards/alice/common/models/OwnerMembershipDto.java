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
public class OwnerMembershipDto extends MembershipDto {
    // -1 means infinite
    @Min(-1)
    private Integer numMaxAccumulatedTotalStores;
    @Min(-1)
    private Integer numMaxCurrentTotalStores;
    @Min(-1)
    private Integer numMaxCurrentActiveStores;
    @Min(-1)
    private Integer numMaxCurrentTotalBlueprintsPerStore;
    @Min(-1)
    private Integer numMaxCurrentActiveBlueprintsPerStore;
    @Min(-1)
    private Integer numMaxCurrentTotalRedeemRulesPerBlueprint;
    @Min(-1)
    private Integer numMaxCurrentActiveRedeemRulesPerBlueprint;
}
