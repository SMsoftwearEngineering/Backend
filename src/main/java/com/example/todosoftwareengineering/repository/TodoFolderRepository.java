package com.example.todosoftwareengineering.repository;

import com.example.todosoftwareengineering.domain.TodoFolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoFolderRepository extends JpaRepository<TodoFolderEntity,Long> {
}
