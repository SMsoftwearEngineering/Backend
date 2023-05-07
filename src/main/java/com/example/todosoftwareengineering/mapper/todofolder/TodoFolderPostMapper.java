package com.example.todosoftwareengineering.mapper.todofolder;

import com.example.todosoftwareengineering.domain.TodoEntity;
import com.example.todosoftwareengineering.domain.TodoFolderEntity;
import com.example.todosoftwareengineering.dto.TodoDto;
import com.example.todosoftwareengineering.dto.TodoFolderDto;
import com.example.todosoftwareengineering.mapper.GenericMapper;
import org.mapstruct.Mapper;

/**
 * @Mapper : MapStruct Code Generator가 해당 인터페이스의 구현체를 생성해준다.
 * componentModel = "spring" : spring에 맞게 bean으로 등록해준다
 */
@Mapper(componentModel = "spring")
public interface TodoFolderPostMapper extends GenericMapper<TodoFolderDto.TodoFolderPostDto, TodoFolderEntity> {


}