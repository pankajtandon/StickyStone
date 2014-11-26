package com.nayidisha.sticky.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.nayidisha.sticky.domain.config.DomainConfiguration;

@ComponentScan (basePackages="com.nayidisha.sticky.domain")
@EnableAutoConfiguration
@Import (DomainConfiguration.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
