package com.barbulescu.springcloudcontractclient;

import com.barbulescu.springcloudcontractclient.config.TestWebClientConfig;
import com.barbulescu.springcloudcontractclient.rest.HelloRestClient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode.LOCAL;

@ExtendWith(SpringExtension.class)
@AutoConfigureStubRunner(stubsMode = LOCAL, ids = "com.barbulescu:spring-cloud-contract-server")
@ContextConfiguration(classes = {TestWebClientConfig.class, HelloRestClient.class})
public class HelloRestClientTest {

    @Autowired
    private HelloRestClient client;

    @Test
    void clientSide() {
        String response = client.sayHello("Marius");
        Assertions.assertThat(response).isEqualTo("Hello Marius!");
    }

}
