package alexengrig.atomic.plyushkin.rest.service;

import java.net.URI;
import java.util.Optional;

public interface StorageService<T> {
    URI store(T data);

    Optional<T> get(String id);
}
