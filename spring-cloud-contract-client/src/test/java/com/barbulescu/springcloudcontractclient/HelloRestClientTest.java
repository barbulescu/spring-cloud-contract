package com.barbulescu.springcloudcontractclient;

import com.barbulescu.springcloudcontractclient.rest.HelloRestClient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;
import static org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode.LOCAL;

@SpringBootTest(webEnvironment = NONE, properties = {"spring.main.allow-bean-definition-overriding=true"})
@AutoConfigureStubRunner(stubsMode = LOCAL, ids = "com.barbulescu:spring-cloud-contract-server")
@DirtiesContext
@ContextConfiguration(classes = TestWebClientConfiguration.class)
public class HelloRestClientTest {

    @Autowired
    private HelloRestClient client;

    @Test
    void clientSide() {
        String response = client.sayHello("Marius");
        Assertions.assertThat(response).isEqualTo("Hello Marius!");
    }

}
