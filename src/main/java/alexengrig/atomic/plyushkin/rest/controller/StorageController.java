package alexengrig.atomic.plyushkin.rest.controller;

import alexengrig.atomic.plyushkin.rest.constant.StorageMessage;
import alexengrig.atomic.plyushkin.rest.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static alexengrig.atomic.plyushkin.rest.constant.RestUrls.Storage.*;

@RestController
@RequestMapping(API_V1_STORAGE)
@RequiredArgsConstructor
public class StorageController {
    private final StorageService<Object> storageService;

    @GetMapping
    public ResponseEntity<?> info() {
        return ResponseEntity.ok(StorageMessage.INFO);
    }

    @PutMapping
    public ResponseEntity<?> put(@RequestBody Object data) {
        return Optional.ofNullable(data)
                .map(storageService::store)
                .map(ResponseEntity::created)
                .map(ResponseEntity.BodyBuilder::build)
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping(BY_ID)
    public ResponseEntity<?> get(@PathVariable(ID) String id) {
        return Optional.ofNullable(id)
                .flatMap(storageService::get)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
}
