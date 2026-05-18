package org.example.study_springboot.repository;

import org.example.study_springboot.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> finalById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
