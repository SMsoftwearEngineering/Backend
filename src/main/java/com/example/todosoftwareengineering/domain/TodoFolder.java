package com.example.todosoftwareengineering.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "todofolder")
@Getter
@Setter
public class TodoFolder {
    @Id
    @Column(name = "todofolder_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title; //제목
    private String color; //폴더 색상
}
