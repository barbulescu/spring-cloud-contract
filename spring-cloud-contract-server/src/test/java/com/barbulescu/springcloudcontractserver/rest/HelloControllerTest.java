package com.barbulescu.springcloudcontractserver.rest;

import com.barbulescu.springcloudcontractserver.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
        webEnvironment = MOCK,
        classes = {HelloController.class, HelloService.class}
)
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private HelloService helloService;

    @Test
    void normal() throws Exception {
        when(helloService.sayHello("abc"))
                .thenReturn("Hello abc!");

        this.mockMvc.perform(get("/hello").param("name", "abc"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello abc!"));
    }
}
