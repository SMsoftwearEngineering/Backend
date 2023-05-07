package com.example.todosoftwareengineering.dto;

import com.example.todosoftwareengineering.domain.MemberEntity;
import lombok.*;

public class TodoDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TodoPostDto{
        private String title; //제목
        private String content; //내용
        private int priority; //우선순위
        private String todoFolderName; //todofolder 이름 //todo: TodoFolderDto로 변경해야함.
        private MemberEntity memberEntity; //todo: MemberDto로 변경해야함.
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TodoResponseDto{
        private Long id;
        private String title; //제목
        private String content; //내용
        private boolean execution; //수행여부
        private int priority; //우선순위
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TodoDeleteDto{
        private Long id;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TodoPatchDto{
        private Long id;
        private String title; //제목
        private String content; //내용
        private boolean execution; //수행여부
        private int priority; //우선순위
        private String todoFolderTitle; //todofolder 이름 //나중에 TodoFolderDto로 변경해야함.
    }
}
