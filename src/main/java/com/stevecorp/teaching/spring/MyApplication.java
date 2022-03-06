package com.stevecorp.teaching.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class MyApplication {

    public static void main(final String... args) {
        SpringApplication.run(MyApplication.class, args);
    }

}
