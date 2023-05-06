package com.example.todosoftwareengineering.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "todo")
@Getter
@Setter
public class Todo {
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
    private TodoFolder todoFolder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member")
    private Member member;

    private LocalDateTime creationDate; //생성일

    private LocalDateTime completeDate; //종료일
    private LocalDateTime wishCompleteDate; //마감일
}
