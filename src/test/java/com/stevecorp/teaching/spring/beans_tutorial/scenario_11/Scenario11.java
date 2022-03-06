package com.stevecorp.teaching.spring.beans_tutorial.scenario_11;

import com.stevecorp.teaching.spring.beans_tutorial.scenario_11.service.SpringService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Scenario11 {

    @Autowired
    private SpringService springService;

    @Test
    void postConstructPreDestroy() {
        springService.sayHello();
    }

}
