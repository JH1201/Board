package com.example.Web_prac.mapper;

import com.example.Web_prac.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository {

    void save(Member member);

    Member findByUserId(String userId);

    List<Member> getAllMember();

}
