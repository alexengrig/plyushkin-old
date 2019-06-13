package alexengrig.atomic.plyushkin.rest.constant;

public abstract class RestUrls {
    private static final String API = "api";
    private static final String V1 = "v1";
    private static final String SLASH = "/";
    private static final String OPEN = "{";
    private static final String CLOSE = "}";

    private static final String API_V1 = API + SLASH + V1;

    public static class Storage {
        public static final String ID = "id";
        public static final String BY_ID = SLASH + OPEN + ID + CLOSE;
        private static final String STORAGE = "storage";
        public static final String API_V1_STORAGE = API_V1 + SLASH + STORAGE;
    }
}