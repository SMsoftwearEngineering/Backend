package com.example.todosoftwareengineering.service;

import com.example.todosoftwareengineering.domain.TodoFolderEntity;
import com.example.todosoftwareengineering.dto.TodoFolderDto;
import com.example.todosoftwareengineering.mapper.todofolder.TodoFolderPostMapper;
import com.example.todosoftwareengineering.mapper.todofolder.TodoFolderResponseMapper;
import com.example.todosoftwareengineering.repository.TodoFolderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class TodoFolderService {

    private final TodoFolderRepository todoFolderRepository;
    private final TodoFolderPostMapper todoFolderPostMapper;
    private final TodoFolderResponseMapper todoFolderResponseMapper;

    @Transactional
    public TodoFolderDto.TodoFolderResponseDto createTodoFolder(TodoFolderDto.TodoFolderPostDto todoFolderPostDto) {
        return todoFolderResponseMapper.toDto(todoFolderRepository.save(todoFolderPostMapper.toEntity(todoFolderPostDto)));
    }

    public TodoFolderEntity getTodoFolder(Long todoFolderId) {
        return todoFolderRepository.findById(todoFolderId).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public void deleteTodoFolder(TodoFolderDto.TodoFolderDeleteDto todoFolderDeleteDto) {
        todoFolderRepository.deleteById(todoFolderDeleteDto.getId());
        log.info("Entity Id: {} is deleted",todoFolderDeleteDto.getId());
    }

    @Transactional
    public TodoFolderDto.TodoFolderResponseDto updateTodoFolder(TodoFolderDto.TodoFolderPatchDto todoFolderPatchDto) {
        TodoFolderEntity todoFolderEntity = todoFolderRepository.findById(todoFolderPatchDto.getId()).orElseThrow(EntityNotFoundException::new);
        todoFolderEntity.update(todoFolderPatchDto);
        return todoFolderResponseMapper.toDto(todoFolderRepository.findById(todoFolderPatchDto.getId()).orElseThrow(EntityNotFoundException::new));

    }


}
