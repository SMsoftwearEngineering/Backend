package com.example.todosoftwareengineering.repository;

import com.example.todosoftwareengineering.domain.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity,Long> {
}
