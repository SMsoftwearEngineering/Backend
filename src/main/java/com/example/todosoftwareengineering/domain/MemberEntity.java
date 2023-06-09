package com.example.todosoftwareengineering.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter
@Setter
public class MemberEntity {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name; //이름
    @Column(unique = true,nullable = false)
    private String email; //이메일 (ID)

    @Column(nullable = false)
    private String password; //비밀번호
}
