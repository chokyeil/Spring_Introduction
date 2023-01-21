package com.example.hellospring.service;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemberRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MemberService {

    private final MemberRespository memberRespository;

    @Autowired
    public MemberService(MemberRespository memberRespository) {
        this.memberRespository = memberRespository;
    }


    /**
     * 회원가입
     */
    public Long join(Member member){

        validateDuplicatieMember(member); // 중복 회원 검증
        memberRespository.save(member);
        return member.getId();
    }

    private void validateDuplicatieMember(Member member) {
        memberRespository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRespository.findAll();
    }

    public Optional<Member> findOne(Long id){
        return memberRespository.findById(id);
    }

}
