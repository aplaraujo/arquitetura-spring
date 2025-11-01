package com.example.arquitetura_spring.todos.repository;

import com.example.arquitetura_spring.todos.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
    boolean existsByDescricao(String descricao);
}
