package org.example.creational.builder;

public class Main {
    public static void main(String[] args) {
        HttpRequest request1 = HttpRequest.builder()
                .url("https://api.example.com")
                .build();
        System.out.println(request1);


        HttpRequest request2 = HttpRequest.builder()
                .url("https://api.example.com")
                .body("Body of Request 2")
                .header("Content-Type", "application/json")
                .queryParam("param1", "value1")
                .timeout(5000)
                .build();
        System.out.println(request2);


        HttpRequest request3 = HttpRequest.builder()
                .url("https://api.example.com")
                .body("Body of Request 3")
                .method("POST")
                .queryParam("param1", "value1")
                .build();
        System.out.println(request3);


        System.out.println("\n-------------------------------------\n");


        HttpRequestDirector director = new HttpRequestDirector();

        HttpRequest r1 = director.createGetJsonRequest("https://api.example.com/users");
        System.out.println(r1);

        HttpRequest r2 = director.createPostJsonRequest("https://api.example.com/users", "{\"name\": \"Ahmed\"}");
        System.out.println(r2);

        HttpRequest r3 = director.createAuthorizedRequest("https://api.example.com/admin", "SECRET_TOKEN");
        System.out.println(r3);
    }
}
