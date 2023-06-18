package com.example.my.model.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.my.model.todo.entity.TodoEntity;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoEntity,Integer> {

    List<TodoEntity> findByDeleteDateIsNull();
    TodoEntity findByIdxAndDeleteDateIsNull(Integer idx);

}
