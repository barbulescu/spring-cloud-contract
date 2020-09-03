package com.barbulescu.springcloudcontractserver;

import org.springframework.stereotype.Component;

import static java.util.Objects.requireNonNull;

@Component
public class HelloService {

    public String sayHello(String name) {
        requireNonNull(name, "name");
        System.out.println("say hello to " + name);
        return "Hello " + name + "!";
    }
}
