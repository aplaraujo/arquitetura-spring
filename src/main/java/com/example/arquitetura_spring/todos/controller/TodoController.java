package com.example.arquitetura_spring.todos.controller;

import com.example.arquitetura_spring.todos.entity.TodoEntity;
import com.example.arquitetura_spring.todos.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo) {
        try {
            return this.todoService.salvar(todo);
        } catch (IllegalArgumentException e) {
            var erro = e.getMessage();
            throw new ResponseStatusException(HttpStatus.CONFLICT, erro);
        }

    }

    @PutMapping("/{id}")
    public void atualizarStatus(@PathVariable("id") Integer id, @RequestBody TodoEntity todo) {
        todo.setId(id);
        todoService.atualizarStatus(todo);
    }

    @GetMapping("/{id}")
    public TodoEntity buscar(@PathVariable("id") Integer id) {
        return todoService.buscarPorId(id);
    }
}
