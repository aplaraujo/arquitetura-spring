package com.example.arquitetura_spring;

import com.example.arquitetura_spring.todos.entity.TodoEntity;
import com.example.arquitetura_spring.todos.validator.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Singleton - escopo padrão de um Bean (padrão de projeto no qual existe uma instância única que vai atender a toda aplicação)
// Request - escopo para aplicações Web
// Session - objeto que dura enquanto a sessão do usuário durar também
// Application - escopo que se estende a todos os usuários
// @Scope("singleton")
// @Scope(BeanDefinition.SCOPE_SINGLETON)
@Component
// Lazy - só será carregado quando for necessário
// @Lazy(value = true)
public class BeanGerenciado {
    // Forma de injetar dependência via propriedade
    @Autowired
    private TodoValidator todoValidator;

    // Forma de injetar dependência por método construtor (recomendado pelo Spring Boot)
    @Autowired
    public BeanGerenciado(TodoValidator todoValidator) {
        this.todoValidator = todoValidator;
    }

    public void utilizar() {
        var todo = new TodoEntity();
        todoValidator.validar(todo);
    }

    // Forma de injetar dependência com métodos de configuração (Setter)
    @Autowired
    public void setTodoValidator(TodoValidator todoValidator) {
        this.todoValidator = todoValidator;
    }
}
