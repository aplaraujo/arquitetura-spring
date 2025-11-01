package com.example.arquitetura_spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExemploValue {
    @Value("${app.config.variavel}") // Injeção do valor de uma variável
    private String variavel;

    public void imprimir() {
        System.out.println(variavel);
    }

}
