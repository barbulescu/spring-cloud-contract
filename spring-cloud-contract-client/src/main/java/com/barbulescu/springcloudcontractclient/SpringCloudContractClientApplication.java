package com.barbulescu.springcloudcontractclient;

import com.barbulescu.springcloudcontractclient.jms.HelloJmsClient;
import com.barbulescu.springcloudcontractclient.rest.HelloRestClient;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.springframework.boot.WebApplicationType.NONE;

@SpringBootApplication
public class SpringCloudContractClientApplication {

	private final HelloRestClient helloRestClient;
	private final HelloJmsClient helloJmsClient;

	public SpringCloudContractClientApplication(
			HelloRestClient helloRestClient,
			HelloJmsClient helloJmsClient) {
		this.helloRestClient = helloRestClient;
		this.helloJmsClient = helloJmsClient;
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringCloudContractClientApplication.class);
		app.setWebApplicationType(NONE);
		app.run(args);
	}

	@Bean
	ApplicationRunner jmsRunner() {
		return args -> System.out.println(helloJmsClient.sayHello("Marius"));
	}
	@Bean
	ApplicationRunner restRunner() {
		return args -> System.out.println(helloRestClient.sayHello("Marius"));
	}
}
