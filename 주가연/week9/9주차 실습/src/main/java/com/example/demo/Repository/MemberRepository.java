package com.example.demo.Repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);              // 이름으로 조회

}