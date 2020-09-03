package com.barbulescu.springcloudcontractclient.jms;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class HelloJmsClient {

    private final JmsTemplate jmsTemplate;

    public HelloJmsClient(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public String sayHello(String name) {
        try {
            jmsTemplate.send("hello-request", session -> session.createTextMessage("Marius"));
            ActiveMQTextMessage response = (ActiveMQTextMessage) jmsTemplate.receive("hello-response");
            return response.getText();
        } catch (JMSException e) {
            throw new RuntimeException("Unable to say hello", e);
        }
    }
}
