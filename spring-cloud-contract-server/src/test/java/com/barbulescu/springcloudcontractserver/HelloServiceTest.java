package com.barbulescu.springcloudcontractserver;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HelloServiceTest {

    private final HelloService service = new HelloService();

    @Test
    void normal() {
        String response = service.sayHello("abc");
        assertThat(response).isEqualTo("Hello abc!");
    }

    @Test
    void nullName() {
        assertThatThrownBy(() -> service.sayHello(null))
                .isExactlyInstanceOf(NullPointerException.class)
                .hasMessage("name");

    }
}