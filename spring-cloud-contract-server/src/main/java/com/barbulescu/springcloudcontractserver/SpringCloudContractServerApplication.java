package com.barbulescu.springcloudcontractserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringCloudContractServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudContractServerApplication.class, args);
    }

}
