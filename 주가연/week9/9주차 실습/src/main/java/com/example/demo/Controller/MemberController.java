package com.example.demo.Controller;

import com.example.demo.Service.MemberService;
import com.example.demo.domain.Member;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @PostMapping
    public Member save(@RequestBody Member member) {
        return service.save(member);
    }

    @GetMapping
    public List<Member> findAll() {
        return service.findAll();
    }

    @GetMapping("/search/name")
    public List<Member> findByName(@RequestParam String name) {
        return service.findByName(name);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
