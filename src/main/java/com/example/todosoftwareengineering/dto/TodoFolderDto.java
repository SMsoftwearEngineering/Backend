package com.example.todosoftwareengineering.dto;

import com.example.todosoftwareengineering.domain.Member;
import lombok.*;

import javax.persistence.Column;

public class TodoFolderDto {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TodoFolderPostDto{
        private String title; //제목
        private String color; //폴더 색상
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TodoFolderResponseDto{
        private Long id;
        private String title; //제목
        private String color; //폴더 색상
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TodoFolderDeleteDto{
        private Long id;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TodoFolderPatchDto{
        private Long id;
        private String title; //제목
        private String color; //폴더 색상
    }
}
