package com.stevecorp.teaching.spring.beans_tutorial.scenario_02.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SpringService {

    public void sayHello() {
        log.info("Hello!");
    }

}