package com.example.demo.base;

import com.example.demo.rest.EvenOddController;
import com.example.demo.rest.EvenOddService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = BaseTestClass.TestConfiguration.class)
public abstract class BaseTestClass {

    @Autowired
    EvenOddController controller;

    @MockBean
    EvenOddService service;

    @Before
    public void setup() {
        when(service.calculate(2)).thenReturn("Even");
        when(service.calculate(1)).thenReturn("Odd");

        StandaloneMockMvcBuilder standaloneMockMvcBuilder
                = MockMvcBuilders.standaloneSetup(controller);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }

    @Test
    public void init() {

    }

    @Configuration
    @EnableAutoConfiguration
    @Import(EvenOddController.class)
    public static class TestConfiguration {
    }

}
