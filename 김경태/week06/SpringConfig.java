package com.example.week6hw;

import com.example.week6hw.repository.MemberRepository;
import com.example.week6hw.repository.MemoryMemberRepository;
import com.example.week6hw.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
