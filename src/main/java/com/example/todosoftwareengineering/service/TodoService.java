package com.example.todosoftwareengineering.service;

import com.example.todosoftwareengineering.domain.TodoEntity;
import com.example.todosoftwareengineering.domain.TodoFolderEntity;
import com.example.todosoftwareengineering.dto.TodoDto;
import com.example.todosoftwareengineering.mapper.todo.TodoPostMapper;
import com.example.todosoftwareengineering.mapper.todo.TodoResponseMapper;
import com.example.todosoftwareengineering.repository.TodoFolderRepository;
import com.example.todosoftwareengineering.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class TodoService {

    private final TodoRepository todoRepository;
    private final TodoFolderRepository todoFolderRepository;
    private final TodoPostMapper todoPostMapper;
    private final TodoResponseMapper todoResponseMapper;


    @Transactional
    public TodoDto.TodoResponseDto createTodo(TodoDto.TodoPostDto todoPostDto) {
        return todoResponseMapper.toDto(todoRepository.save(todoPostMapper.toEntity(todoPostDto)));
    }

    public List<TodoEntity> getTodos(Long memberId) {
        return todoRepository.findByMemberId(memberId);
    }

    @Transactional
    public void deleteTodo(TodoDto.TodoDeleteDto todoDeleteDto) {
        todoRepository.deleteById(todoDeleteDto.getId());
        log.info("Entity Id: {} is deleted",todoDeleteDto.getId());
    }

    @Transactional
    public TodoDto.TodoResponseDto updateTodo(TodoDto.TodoPatchDto todoPatchDto) {
        TodoEntity todoEntity = todoRepository.findById(todoPatchDto.getId()).orElseThrow(EntityNotFoundException::new);
        TodoFolderEntity byTitle = todoFolderRepository.findByTitle(todoPatchDto.getTitle());
        todoEntity.update(todoPatchDto,byTitle);
        log.info("Entity Id: {} is updated",todoPatchDto.getId());
        return todoResponseMapper.toDto(todoRepository.findById(todoPatchDto.getId()).orElseThrow(EntityNotFoundException::new));
    }
}
