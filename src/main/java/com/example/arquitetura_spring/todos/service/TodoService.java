package com.example.arquitetura_spring.todos.service;

import com.example.arquitetura_spring.todos.entity.TodoEntity;
import com.example.arquitetura_spring.todos.repository.TodoRepository;
import com.example.arquitetura_spring.todos.validator.MailSender;
import com.example.arquitetura_spring.todos.validator.TodoValidator;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
// Concentração das regras de negócio do projeto
@Service
public class TodoService {

    private TodoRepository todoRepository;
    private TodoValidator todoValidator;
    private MailSender mailSender;

    // Quando tem um construtor injetando uma dependência, a anotação @Autowired não é necessária
    public TodoService(TodoRepository todoRepository, TodoValidator todoValidator, MailSender mailSender) {
        this.todoRepository = todoRepository;
        this.todoValidator = todoValidator;
        this.mailSender = mailSender;
    }

    public TodoEntity salvar(TodoEntity novoTodo) {
        todoValidator.validar(novoTodo);
        return todoRepository.save(novoTodo);
    }

    public void atualizarStatus(TodoEntity todo) {
        todoRepository.save(todo);
        String status = todo.getConcluido() == Boolean.TRUE ? "Concluído" : "Não foi concluído";
        mailSender.enviar("TODO de código " + todo.getDescricao() + " foi atualizado para: " + status);
    }

    public TodoEntity buscarPorId(@PathVariable("id") Integer id) {
        Optional<TodoEntity> todo = todoRepository.findById(id);
        return todo.orElse(null);
    }
}
