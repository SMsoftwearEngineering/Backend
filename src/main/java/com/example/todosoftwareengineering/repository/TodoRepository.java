package com.example.todosoftwareengineering.repository;

import com.example.todosoftwareengineering.domain.Todo;
import com.example.todosoftwareengineering.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
