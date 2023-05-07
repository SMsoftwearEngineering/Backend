package com.example.todosoftwareengineering.domain;

import com.example.todosoftwareengineering.dto.TodoDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "todo")
@Getter
@Setter
public class TodoEntity {
    @Id
    @Column(name = "todo_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title; //제목

    @Lob
    private String content; //내용

    private boolean execution; //수행여부

    private int priority; //우선순위

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todofolder_id")
    private TodoFolderEntity todoFolderEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;

    private LocalDateTime creationDate; //생성일

    private LocalDateTime completeDate; //종료일
    private LocalDateTime wishCompleteDate; //마감일


    public void update(TodoDto.TodoPatchDto todoPatchDto,TodoFolderEntity todoFolderEntity) {
        this.title = todoPatchDto.getTitle();
        this.content = todoPatchDto.getContent();
        this.execution = todoPatchDto.isExecution();
        this.priority = todoPatchDto.getPriority();
        this.todoFolderEntity = todoFolderEntity;
    }
}
