package com.example.hellospring.controller;

import com.example.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

//    @Autowired private MemberService memberService;   // 필드 주입 단점은 뭔가 바꿔줄 수가 없다.

//    private MemberService memberService;

        private final MemberService memberService;

//    @Autowired      // setter 의존성 주입 단점은 누군가가 멤버 컨트롤을 호출했을 때 public으로 열려있어야 한다.
//                    // 이러면 어느 누구든 접근을 할 수 있게 되어 데이터가 바뀔 위험이 커진다.
//    public void setMemberService(MemberService memberService){
//        this.memberService = memberService;
//    }

    @Autowired        // 생성자를 통한 DI
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
