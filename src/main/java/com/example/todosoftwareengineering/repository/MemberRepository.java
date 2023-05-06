package com.example.todosoftwareengineering.repository;

import com.example.todosoftwareengineering.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
