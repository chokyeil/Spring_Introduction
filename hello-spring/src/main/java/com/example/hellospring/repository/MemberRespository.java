package com.example.hellospring.repository;


import com.example.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRespository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
