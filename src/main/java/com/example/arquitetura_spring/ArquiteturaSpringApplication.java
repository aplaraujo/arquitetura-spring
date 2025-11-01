package com.example.arquitetura_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ArquiteturaSpringApplication {

    @Autowired
    private ExemploValue exemploValue;
    public static void main(String[] args) {
    SpringApplication.run(ArquiteturaSpringApplication.class, args);
	}

}
