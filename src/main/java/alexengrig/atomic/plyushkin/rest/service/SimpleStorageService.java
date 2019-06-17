package alexengrig.atomic.plyushkin.rest.service;

import alexengrig.atomic.plyushkin.rest.constant.RestUrls;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class SimpleStorageService implements StorageService<MultipartFile> {
    private final Map<UUID, Object> repository = new HashMap<>(32);

    @Override
    public URI store(MultipartFile data) {
        UUID uuid = getKey();
        String originalFilename = data.getOriginalFilename();
        log.info("Original filename: {}", originalFilename);
        repository.put(uuid, originalFilename);
        return getURI(uuid);
    }

    private UUID getKey() {
        return UUID.randomUUID();
    }

    private URI getURI(UUID uuid) {
        String id = uuid.toString();
        String url = String.format("%s/%s", RestUrls.Storage.API_V1_STORAGE, id);
        return URI.create(url);
    }

    @Override
    public Optional<MultipartFile> get(String id) {
        return Optional.empty();
    }
}
