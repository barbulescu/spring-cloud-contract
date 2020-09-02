package com.barbulescu.springcloudcontractclient.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    private final String helloUrl;

    public WebClientConfig(@Value("${hello.url}") String helloUrl) {
        this.helloUrl = helloUrl;
    }

    @Bean
    WebClient webClient() {
        return WebClient.create(helloUrl);
    }

}
