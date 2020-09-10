package com.barbulescu.springcloudcontractserver.jms;

import com.barbulescu.springcloudcontractserver.HelloService;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class HelloListener {

    private final HelloService helloService;
    private final JmsTemplate jmsTemplate;

    public HelloListener(HelloService helloService, JmsTemplate jmsTemplate) {
        this.helloService = helloService;
        this.jmsTemplate = jmsTemplate;
    }

    @JmsListener(destination = "hello-request")
    void helloListener(ActiveMQTextMessage message) throws JMSException {
        String name = message.getText();
        String correlationId = message.getJMSCorrelationID();
        String response = helloService.sayHello(name);
        jmsTemplate.send("hello-response", session -> {
            TextMessage responseMessage = session.createTextMessage(response);
            responseMessage.setJMSCorrelationID(correlationId);
            responseMessage.setStringProperty("contentType", "text/plain");
            return responseMessage;
        });
    }
}
