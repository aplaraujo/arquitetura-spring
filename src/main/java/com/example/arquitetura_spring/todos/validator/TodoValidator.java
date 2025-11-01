package com.example.arquitetura_spring.todos.validator;

import com.example.arquitetura_spring.todos.entity.TodoEntity;
import com.example.arquitetura_spring.todos.repository.TodoRepository;
import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository todoRepository;

    public TodoValidator(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void validar(TodoEntity todo) {
        if(existeTodoComDescricao(todo.getDescricao())) {
            throw new IllegalArgumentException("Já existe um TODO com essa descrição!");
        }
    }

    private boolean existeTodoComDescricao(String descricao) {
        return todoRepository.existsByDescricao(descricao);
    }
}
