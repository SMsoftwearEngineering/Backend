package com.example.todosoftwareengineering.repository;

import com.example.todosoftwareengineering.domain.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoEntity,Long> {


    //todo: 최적화 필요
    @Query("select t from TodoEntity t " +
            "where t.memberEntity.id = :memberId ")
    List<TodoEntity> findByMemberId(@Param("memberId") Long memberId);
}
