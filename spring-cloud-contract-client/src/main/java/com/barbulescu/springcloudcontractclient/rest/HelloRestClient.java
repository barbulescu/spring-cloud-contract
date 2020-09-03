package com.barbulescu.springcloudcontractclient.rest;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class HelloRestClient {
    private final WebClient webclient;

    public HelloRestClient(WebClient webclient) {
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
