package com.barbulescu.springcloudcontractclient;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.ContextConfiguration;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;
import static org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode.LOCAL;

@SpringBootTest(webEnvironment = NONE, properties = {"spring.main.allow-bean-definition-overriding=true"})
@AutoConfigureStubRunner(stubsMode = LOCAL, ids = "com.barbulescu:spring-cloud-contract-server")
@ContextConfiguration(classes = TestWebClientConfiguration.class)
class SpringCloudContractClientApplicationTests {

	@Test
	void contextLoads() {
	}

}
