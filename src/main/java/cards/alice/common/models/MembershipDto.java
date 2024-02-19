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
public class MembershipDto extends LongDto {
    // Owner features
    // -1 means infinite
    @Min(-1)
    private Integer numMaxAccumulatedTotalStores;
    @Min(-1)
    private Integer numMaxCurrentTotalStores;
    @Min(-1)
    private Integer numMaxCurrentActiveStores;
    @Min(-1)
    private Integer numMaxAccumulatedTotalBlueprints;
    @Min(-1)
    private Integer numMaxCurrentTotalBlueprintsPerStore;
    @Min(-1)
    private Integer numMaxCurrentActiveBlueprintsPerStore;
    @Min(-1)
    private Integer numMaxAccumulatedTotalRedeemRules;
    @Min(-1)
    private Integer numMaxCurrentTotalRedeemRulesPerBlueprint;

    // Customer features
    @Min(-1)
    private Integer numMaxAccumulatedTotalCards;
    @Min(-1)
    private Integer numMaxCurrentTotalCards;
    @Min(-1)
    private Integer numMaxCurrentActiveCards;
}
