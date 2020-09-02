package com.barbulescu.springcloudcontractclient.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class HelloClientConfig {

    private final WebClient webClient;

    public HelloClientConfig(WebClient webClient) {
        this.webClient = webClient;
    }

    @Bean
    HelloClient helloClient() {
        return new HelloClient(webClient);
    }
}
