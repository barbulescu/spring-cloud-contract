package com.barbulescu.springcloudcontractclient.jms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.verifier.messaging.jms.ContractVerifierJmsConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode.LOCAL;

@ExtendWith(SpringExtension.class)
@AutoConfigureStubRunner(
        stubsMode = LOCAL,
        ids = "com.barbulescu:spring-cloud-contract-server")
@ContextConfiguration(classes = {
        JmsConfig.class,
        HelloJmsClient.class,
        ActiveMQAutoConfiguration.class,
        ContractVerifierJmsConfiguration.class,
})
public class HelloJmsClientTest {

    @Autowired
    private StubTrigger stubTrigger;

    @Autowired
    private HelloJmsClient client;

    @Test
    void clientSide() {
        stubTrigger.trigger("basic_hello");

        String response = client.sayHello("Marius");
        //TODO find a way to remove the extra quotes
        assertThat(response).isEqualTo("\"Hello Marius!\"");
    }

}
