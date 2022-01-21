package com.mediaapp.mapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:custom.properties")
public class MetaConfigurations {

    @Value("${prop.name}")
    private String name;

    @Value("${prop.age}")
    private int age;

    @Value("${prop.gender:Male")
    private String gender;

    @Value("#{environment['server.port'] ?: 9090}")
    private int port;

    public Person person(@Value("${prop.name}") String name, @Value("${prop.age}") int age ) {
        return new Person(name, age);
    }

}
