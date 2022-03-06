package com.stevecorp.teaching.spring.beans_tutorial.scenario_07.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ConnectionProperties {

    private final String driverClassName;
    private final String url;
    private final String username;
    private final String password;

}
