package org.example.study_springboot.service;

import org.example.study_springboot.domain.Member;
import org.example.study_springboot.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {
    
    private final MemberRepository memberRepository;

//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        validateDuplicatedMember(member);
        memberRepository.save(member);
        return  member.getId();
    }

    private void validateDuplicatedMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.finalById(memberId);
    }
}
