package com.stevecorp.teaching.spring.beans_tutorial.scenario_11.service;

import com.stevecorp.teaching.spring.beans_tutorial.scenario_11.component.SpringComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Service
public class SpringService {

    private final SpringComponent springComponent;

    public SpringService(SpringComponent springComponent) {
        log.info("--> Calling SpringService Constructor!\n\n");
        this.springComponent = springComponent;
    }

    @PostConstruct
    private void postConstruct() {
        log.info("--> Calling SpringService PostConstruct!");
        log.info("--> SpringComponent is null: {}\n\n", springComponent == null);
    }

    @PreDestroy
    private void preDestroy() {
        log.info("--> Calling SpringService PreDestroy!");
        log.info("--> SpringComponent is null: {}\n\n", springComponent == null);
    }

    public void sayHello() {
        springComponent.sayHello();
    }

}
