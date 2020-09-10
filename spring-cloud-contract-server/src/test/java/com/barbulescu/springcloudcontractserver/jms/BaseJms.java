package com.barbulescu.springcloudcontractserver.jms;

import com.barbulescu.springcloudcontractserver.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.MessageVerifier;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.cloud.contract.verifier.messaging.jms.ContractVerifierJmsConfiguration;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(
        webEnvironment = NONE,
        classes = {
                HelloListener.class,
                HelloService.class,
                ActiveMQAutoConfiguration.class,
                ContractVerifierJmsConfiguration.class,
                JmsConfig.class,
        }
)
@AutoConfigureMessageVerifier
public abstract class BaseJms {
    @Autowired
    private MessageVerifier messaging;
}
