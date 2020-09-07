package com.barbulescu.springcloudcontractclient.config;

import org.apache.activemq.broker.BrokerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableJms
public class EmbeddedActiveMQConfig {

    @Bean(initMethod = "start", destroyMethod = "stop")
    BrokerService broker() throws Exception {
        BrokerService broker = new BrokerService();
        broker.addConnector("vm://localhost");
        broker.setPersistent(false);
        broker.setUseJmx(false);
        broker.setWaitForSlave(false);
        broker.setUseShutdownHook(true);
        return broker;
    }

}
