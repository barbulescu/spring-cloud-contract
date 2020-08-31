package com.barbulescu.springcloudcontractclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

import static org.springframework.boot.WebApplicationType.NONE;

@SpringBootApplication
public class SpringCloudContractClientApplication {

	private final HelloClient helloClient;

	public SpringCloudContractClientApplication(HelloClient helloClient) {
		this.helloClient = helloClient;
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringCloudContractClientApplication.class);
		app.setWebApplicationType(NONE);
		app.run(args);
	}

	@PostConstruct
	void postConstruct() {
		System.out.println(helloClient.sayHello("Marius"));
	}

}
