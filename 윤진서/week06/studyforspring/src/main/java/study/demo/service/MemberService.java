package study.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.demo.domain.Member;
import study.demo.repository.MemberRepository;
import study.demo.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;
@Service//스프링이 올라올 때 클래스를 서비스로 인식하고 스프링 컨테이너에 멤버서비스 등록
public class MemberService {

    private final MemberRepository memberRepository;
    //@Autowired
    //autowired를 통한 ui는 스프링이 관리하는 객체에서만 동작한다.
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    /*
    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
     */

    //회원가입
    public Long join(Member member) {
        validateDuplicateMember(member);//중복회원
        memberRepository.save(member);
        return member.getId();
    }

    //중복회원검증
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    //전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }



}



