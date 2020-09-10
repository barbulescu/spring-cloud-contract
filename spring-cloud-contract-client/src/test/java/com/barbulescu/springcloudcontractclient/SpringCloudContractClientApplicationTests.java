package com.barbulescu.springcloudcontractclient;

import com.barbulescu.springcloudcontractclient.rest.TestWebClientConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;
import static org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode.LOCAL;

@SpringBootTest(
        webEnvironment = NONE,
        classes = {
                TestWebClientConfig.class,
                ActiveMQAutoConfiguration.class,
        },
        properties = {"spring.main.allow-bean-definition-overriding=true"})
@AutoConfigureStubRunner(stubsMode = LOCAL, ids = "com.barbulescu:spring-cloud-contract-server")
class SpringCloudContractClientApplicationTests {

    @Test
    void contextLoads() {
    }

}
