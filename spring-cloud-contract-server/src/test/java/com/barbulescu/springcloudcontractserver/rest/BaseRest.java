package com.barbulescu.springcloudcontractserver.rest;

import com.barbulescu.springcloudcontractserver.HelloService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;

@SpringBootTest(
        webEnvironment = MOCK,
        classes = {HelloController.class}
)
@AutoConfigureMessageVerifier
public abstract class BaseRest {

    @Autowired
    private HelloController helloController;

    @MockBean
    private HelloService helloService;


    @BeforeEach
    void setup() {
        standaloneSetup(helloController);
        when(helloService.sayHello("Marius"))
                .thenReturn("Hello Marius!");
    }
}
