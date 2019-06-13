package alexengrig.atomic.plyushkin.rest.service;

import alexengrig.atomic.plyushkin.rest.constant.RestUrls;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class SimpleStorageService implements StorageService<Object> {
    private final Map<UUID, Object> repository = new HashMap<>(32);

    @Override
    public URI store(Object data) {
        UUID uuid = getKey();
        repository.put(uuid, data);
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
    public Optional<Object> get(String id) {
        return Optional.ofNullable(repository.get(UUID.fromString(id)));
    }
}
