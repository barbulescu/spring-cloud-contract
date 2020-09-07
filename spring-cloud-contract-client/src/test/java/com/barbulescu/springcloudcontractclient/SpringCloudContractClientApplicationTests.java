package com.barbulescu.springcloudcontractclient;

import com.barbulescu.springcloudcontractclient.config.EmbeddedActiveMQConfig;
import com.barbulescu.springcloudcontractclient.config.TestWebClientConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;
import static org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode.LOCAL;

@SpringBootTest(
        webEnvironment = NONE,
        classes = {TestWebClientConfig.class, EmbeddedActiveMQConfig.class},
        properties = {"spring.main.allow-bean-definition-overriding=true"})
@AutoConfigureStubRunner(stubsMode = LOCAL, ids = "com.barbulescu:spring-cloud-contract-server")
class SpringCloudContractClientApplicationTests {

    @Test
    void contextLoads() {
    }

}
