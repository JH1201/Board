package com.example.Web_prac.service;

import com.example.Web_prac.domain.Member;
import com.example.Web_prac.mapper.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void save(String userName ,String userId, String userPw) {

        Member member = new Member();
        member.setUserName(userName);
        member.setUserId(userId);
        member.setUserPw(userPw);

        memberRepository.save(member);

    }


    public Member findUser(String userId) {
        return memberRepository.findByUserId(userId);
    }

}
