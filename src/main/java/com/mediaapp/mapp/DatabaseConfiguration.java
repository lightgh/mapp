package com.mediaapp.mapp;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;


// Do always and always Read Spring Documentation always
@Configuration
public class DatabaseConfiguration {

    @Profile("dev")
    @Bean
    public DataSource devDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:test");
        dataSourceBuilder.username("SA");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }

    @Profile("prod")
    @Bean
    public DataSource prodDataSource() {
        return null;
    }

    @Profile({"qa", "stage"})
    @Bean
    public DataSource qaDataSource() {
        return null;
    }

}
