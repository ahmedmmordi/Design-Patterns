package org.example.creational.builder;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private final String url; // Required
    private final String method;
    private final Map<String, String> headers;
    private final Map<String, String> queryParams;
    private final String body;
    private final int timeout;

    private HttpRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = new HashMap<>(builder.headers);
        this.queryParams = new HashMap<>(builder.queryParams);
        this.body = builder.body;
        this.timeout = builder.timeout;
    }

    @Override
    public String toString() {
        return "HttpRequest {\n" +
                "    url='" + url + "',\n" +
                "    method='" + method + "',\n" +
                "    headers=" + headers + ",\n" +
                "    queryParams=" + queryParams + ",\n" +
                "    body='" + body + "',\n" +
                "    timeout=" + timeout + ",\n" +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String url; // Required
        private String method;
        private Map<String, String> headers = new HashMap<>();
        private Map<String, String> queryParams = new HashMap<>();
        private String body;
        private int timeout;

        private Builder() {}

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder method(String method) {
            this.method = method;
            return this;
        }

        public Builder header(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public Builder queryParam(String key, String value) {
            this.queryParams.put(key, value);
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public HttpRequest build() {
            if (url == null) {
                throw new IllegalStateException("URL Is Required.");
            }
            if (method == null) {
                method = "GET";
            }
            if (body == null) {
                body = "";
            }
            return new HttpRequest(this);
        }
    }
}
