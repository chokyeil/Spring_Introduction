package com.example.hellospring;

import com.example.hellospring.repository.*;
import com.example.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRespository memberRespository;

    @Autowired
    public SpringConfig(MemberRespository memberRespository) {
        this.memberRespository = memberRespository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRespository);
    }

//    @Bean
//    public MemberRespository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
