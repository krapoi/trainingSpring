package com.train.trainingSpring.repository;

import com.train.trainingSpring.Repository.MemoryMemberRepository;
import com.train.trainingSpring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearstore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("string");

        repository.save(member);

        Member result = repository.findbyId(member.getId()).get();

        Assertions.assertEquals(member, result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("string");
        repository.save(member1);

        Member member2 = new Member();
        member1.setName("ing");
        repository.save(member2);

        Member result = repository.findbyName("string").get();

        Assertions.assertEquals(result,member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member1.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertEquals(result.size(), 2);

    }
}
