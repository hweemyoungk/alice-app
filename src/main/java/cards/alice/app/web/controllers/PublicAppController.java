package cards.alice.app.web.controllers;

import cards.alice.common.models.AppNoticeDto;
import cards.alice.common.models.CustomerMembershipDto;
import cards.alice.common.models.OwnerMembershipDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("${cards.alice.app.web.controllers.path.base}")
@RequiredArgsConstructor
public class PublicAppController {
    private final Map<String, String> minRequirements;
    private final Map<Long, AppNoticeDto> appNoticeMap;
    private final Map<String, CustomerMembershipDto> customerMembershipMap;
    private final Map<String, OwnerMembershipDto> ownerMembershipMap;

    @GetMapping(path = "${cards.alice.app.web.controllers.path.public.min-requirements}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Map<String, String>> getMinRequirements() {
        return ResponseEntity.ok(minRequirements);
    }

    @GetMapping(path = "${cards.alice.app.web.controllers.path.public.app-notice.list.id}",
            produces = "application/json;charset=UTF-8")
    public ResponseEntity<Collection<Long>> listAppNoticesId() {
        return ResponseEntity.ok(appNoticeMap.keySet());
    }

    @GetMapping(path = "${cards.alice.app.web.controllers.path.public.app-notice.list}",
            produces = "application/json;charset=UTF-8")
    public ResponseEntity<Collection<AppNoticeDto>> listAppNotices(@RequestParam(required = false) Set<Long> ids) {
        if (ids == null) {
            return ResponseEntity.ok(appNoticeMap.values());
        }

        final var list = new ArrayList<AppNoticeDto>();
        ids.forEach(id -> {
            AppNoticeDto appNoticeDto = appNoticeMap.get(id);
            if (appNoticeDto == null) {
                return;
            }
            list.add(appNoticeDto);
        });
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "${cards.alice.app.web.controllers.path.public.customer.membership.map}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Map<String, CustomerMembershipDto>> getCustomerMembershipMap() {
        return ResponseEntity.ok(customerMembershipMap);
    }

    @GetMapping(path = "${cards.alice.app.web.controllers.path.public.owner.membership.map}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Map<String, OwnerMembershipDto>> getOwnerMembershipMap() {
        return ResponseEntity.ok(ownerMembershipMap);
    }
}
