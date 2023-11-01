package com.example.spring_jpa_data.repository;

import com.example.spring_jpa_data.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Page<Member> findByAge(int age, Pageable pageable);
}
