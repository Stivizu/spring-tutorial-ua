package com.stevecorp.teaching.spring.beans_tutorial.scenario_06;

import com.stevecorp.teaching.spring.beans_tutorial.scenario_02.service.JavaService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootTest
public class Scenario06 {

    @Autowired
    private ApplicationContext context;

    @Test
    void usingComponentScanning() {
        try {
            final JavaService javaService = context.getBean(JavaService.class);
            javaService.sayHello();
        } catch (Exception e) {
            log.error("Exception while trying to retrieve bean of type {}", JavaService.class.getSimpleName(), e);
        }

        /*
            By default, a Spring application looks for components (@Service, @Configuration, @Component, @Controller, @Repository) starting from its own package.
             By using @ComponentScan, we can add or remove other packages to/from where Spring looks for these components.
             Try commenting the @ComponentScan annotation in the BeanConfiguration class.
             Then Spring would no longer scan that package as well, and will no longer be able to find the JavaService bean.
         */
    }

}
