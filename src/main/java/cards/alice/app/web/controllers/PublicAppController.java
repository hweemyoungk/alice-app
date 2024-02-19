package cards.alice.app.web.controllers;

import cards.alice.common.models.MembershipDto;
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
    private final Map<String, MembershipDto> membershipMap;

    @GetMapping(path = "${cards.alice.app.web.controllers.path.public.min-requirements}")
    public ResponseEntity<Map<String, String>> getMinRequirements() {
        return ResponseEntity.ok(minRequirements);
    }

    @GetMapping(path = "${cards.alice.app.web.controllers.path.public.membership.map}")
    public ResponseEntity<Map<String, MembershipDto>> mapMemberships() {
        return ResponseEntity.ok(membershipMap);
    }
}
