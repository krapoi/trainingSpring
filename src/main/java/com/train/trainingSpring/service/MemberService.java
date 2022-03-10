package com.train.trainingSpring.service;

import com.train.trainingSpring.Repository.MemberRepository;
import com.train.trainingSpring.Repository.MemoryMemberRepository;
import com.train.trainingSpring.domain.Member;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public Long join(Member member){
        // 같은 이름이 있는 중복 회원은 X
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member){
        memberRepository.findbyName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long MemberId){
        return  memberRepository.findbyId(MemberId);
    }
}