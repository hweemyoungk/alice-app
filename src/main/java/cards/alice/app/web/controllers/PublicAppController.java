package cards.alice.app.web.controllers;

import cards.alice.common.models.CustomerMembershipDto;
import cards.alice.common.models.OwnerMembershipDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("${cards.alice.app.web.controllers.path.base}")
@RequiredArgsConstructor
public class PublicAppController {
    private final Map<String, String> minRequirements;
    private final Map<String, CustomerMembershipDto> customerMembershipMap;
    private final Map<String, OwnerMembershipDto> ownerMembershipMap;

    @GetMapping(path = "${cards.alice.app.web.controllers.path.public.min-requirements}")
    public ResponseEntity<Map<String, String>> getMinRequirements() {
        return ResponseEntity.ok(minRequirements);
    }

    @GetMapping(path = "${cards.alice.app.web.controllers.path.public.customer.membership.map}")
    public ResponseEntity<Map<String, CustomerMembershipDto>> getCustomerMembershipMap() {
        return ResponseEntity.ok(customerMembershipMap);
    }

    @GetMapping(path = "${cards.alice.app.web.controllers.path.public.owner.membership.map}")
    public ResponseEntity<Map<String, OwnerMembershipDto>> getOwnerMembershipMap() {
        return ResponseEntity.ok(ownerMembershipMap);
    }
}
