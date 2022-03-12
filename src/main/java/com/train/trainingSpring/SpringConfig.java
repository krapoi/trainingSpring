package com.train.trainingSpring;

import com.train.trainingSpring.Repository.MemberRepository;
import com.train.trainingSpring.Repository.MemoryMemberRepository;
import com.train.trainingSpring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return  new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}

