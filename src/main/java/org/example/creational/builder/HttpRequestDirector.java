package org.example.creational.builder;

public class HttpRequestDirector {
    public HttpRequest createGetJsonRequest(String url) {
        return HttpRequest.builder()
                .url(url)
                .method("GET")
                .header("Accept", "application/json")
                .build();
    }

    public HttpRequest createPostJsonRequest(String url, String body) {
        return HttpRequest.builder()
                .url(url)
                .method("POST")
                .header("Content-Type", "application/json")
                .body(body)
                .build();
    }

    public HttpRequest createAuthorizedRequest(String url, String token) {
        return HttpRequest.builder()
                .url(url)
                .method("GET")
                .header("Authorization", "Bearer " + token)
                .timeout(5000)
                .build();
    }
}
