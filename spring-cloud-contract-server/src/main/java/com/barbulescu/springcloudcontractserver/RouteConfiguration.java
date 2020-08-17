package com.barbulescu.springcloudcontractserver;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RouterFunctions.route;
import static org.springframework.web.servlet.function.ServerResponse.badRequest;
import static org.springframework.web.servlet.function.ServerResponse.ok;

//@Configuration
public class RouteConfiguration {

    private final HelloService helloService;

    public RouteConfiguration(HelloService helloService) {
        this.helloService = helloService;
    }

    @Bean
    public RouterFunction<ServerResponse> routeFunction() {
        return route()
                .GET("/hello", this::hello)
                .build();
    }

    @NotNull
    private ServerResponse hello(ServerRequest req) {
        return req.param("name")
                .map(helloService::sayHello)
                .map(response -> ok().body(response))
                .orElseGet(() -> badRequest().body("name request parameter must not be null!"));
    }
}
