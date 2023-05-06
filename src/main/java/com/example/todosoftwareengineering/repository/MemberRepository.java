package com.example.todosoftwareengineering.repository;

import com.example.todosoftwareengineering.domain.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
}
