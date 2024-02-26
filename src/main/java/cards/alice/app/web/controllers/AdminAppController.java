package cards.alice.app.web.controllers;

import cards.alice.common.models.AppNoticeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("${cards.alice.app.web.controllers.path.base}")
@RequiredArgsConstructor
public class AdminAppController {
    @Value("${cards.alice.app.server.host}:${cards.alice.app.server.port}")
    private String appHostname;
    @Value("${cards.alice.app.web.controllers.path.base}${cards.alice.app.web.controllers.path.admin.app-notice}")
    private String appAppNoticePath;

    private final Map<Long, AppNoticeDto> appNoticeMap;
    private final AtomicLong appNoticeIdManager;

    @PostMapping(path = "${cards.alice.app.web.controllers.path.admin.app-notice}")
    public ResponseEntity<Void> postAppNotice(@Validated @RequestBody AppNoticeDto appNoticeDto) {
        long newId = appNoticeIdManager.incrementAndGet();
        appNoticeDto.setId(newId);
        appNoticeMap.put(newId, appNoticeDto);
        return ResponseEntity.created(URI.create(appHostname + appAppNoticePath + "/" + appNoticeDto.getId())).build();
    }

    @DeleteMapping(path = "${cards.alice.app.web.controllers.path.admin.app-notice}/{id}")
    public ResponseEntity<Void> deleteAppNotice(@PathVariable Long id) {
        appNoticeMap.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
