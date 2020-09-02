package com.barbulescu.springcloudcontractclient.rest;

import org.springframework.web.reactive.function.client.WebClient;

public class HelloClient {
    private final WebClient webclient;

    public HelloClient(WebClient webclient) {
        this.webclient = webclient;
    }

    public String sayHello(String name) {
        return webclient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/hello")
                        .queryParam("name", name)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }
}
