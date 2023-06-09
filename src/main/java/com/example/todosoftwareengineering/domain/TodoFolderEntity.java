package com.example.todosoftwareengineering.domain;

import com.example.todosoftwareengineering.dto.TodoFolderDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "todofolder")
@Getter
@Setter
public class TodoFolderEntity {
    @Id
    @Column(name = "todofolder_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true,nullable = false)
    private String title; //제목
    private String color; //폴더 색상

    //있어야하는지 다시 생각해볼것.
    @OneToMany(mappedBy = "todoFolderEntity" , cascade = CascadeType.ALL)
    private List<TodoEntity> todoEntities = new ArrayList<>();

    public void update(TodoFolderDto.TodoFolderPatchDto todoFolderPatchDto) {
        this.title = todoFolderPatchDto.getTitle();
        this.color = todoFolderPatchDto.getColor();
    }
}
