package study.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import study.demo.service.MemberService;

@Controller
public class MemberController {
    //스프링 컨테이너에 등록하고 사용
    private final MemberService memberService;
    //DI
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
        //memberService.setMemberRepository(); DI setter 주입
    }
    //@Autowired private MemberService memberService; 필드 주입
    //
}
