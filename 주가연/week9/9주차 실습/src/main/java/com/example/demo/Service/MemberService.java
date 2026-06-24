package com.example.demo.Service;

import com.example.demo.Repository.MemberRepository;
import com.example.demo.domain.Member;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    // 저장
    public Member save(Member member) {
        member.setId(null);
        return repository.save(member);
    }

    // 전체 조회
    public List<Member> findAll() {
        return repository.findAll();
    }

    // 이름으로 조회
    public List<Member> findByName(String name) {
        return repository.findByName(name);
    }

    // 삭제
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
