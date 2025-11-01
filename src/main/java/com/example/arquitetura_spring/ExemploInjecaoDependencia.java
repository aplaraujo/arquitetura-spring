package com.example.arquitetura_spring;

import com.example.arquitetura_spring.todos.entity.TodoEntity;
import com.example.arquitetura_spring.todos.repository.TodoRepository;
import com.example.arquitetura_spring.todos.service.TodoService;
import com.example.arquitetura_spring.todos.validator.MailSender;
import com.example.arquitetura_spring.todos.validator.TodoValidator;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class ExemploInjecaoDependencia {
    public static void main(String[] args) throws SQLException {
        // Exemplo de arquitetura sem injeção de dependência

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("url");
        dataSource.setUsername("username");
        dataSource.setPassword("password");

        // Conexão com o banco de dados
        Connection connection = dataSource.getConnection();

        // Repositório
        TodoRepository todoRepository = null;
        TodoValidator todoValidator = new TodoValidator(todoRepository);
        MailSender mailSender = new MailSender();
        TodoService todoService = new TodoService(todoRepository, todoValidator, mailSender);
    }
}
