package com.barbulescu.springcloudcontractclient.rest;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.web.reactive.function.client.WebClient.create;

@TestConfiguration
public class TestWebClientConfig {

    @StubRunnerPort("spring-cloud-contract-server")
    private int producerPort;

    @Bean
    @Primary
    WebClient webClient() {
        return create("http://localhost:" + producerPort);
    }
}
