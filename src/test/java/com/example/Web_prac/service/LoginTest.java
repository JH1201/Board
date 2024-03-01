package com.example.Web_prac.service;

import com.example.Web_prac.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginTest {
    private final MemberService memberService;

    @Autowired
    public LoginTest(MemberService memberService) {
        this.memberService = memberService;
    }

    @Test
    @DisplayName("save and find function Test")
    public void loginTestImpl() {

        //given

        String userName = "kim";
        String userId = "asd12";
        String userPw = "123";

        memberService.save(userName, userId, userPw);

        //when
        Member findUser = memberService.findUser(userId);

        //then
        Assertions.assertThat(userId).isEqualTo(findUser.getUserId());
    }
}
