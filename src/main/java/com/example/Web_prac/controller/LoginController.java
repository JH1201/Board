package com.example.Web_prac.controller;

import com.example.Web_prac.domain.Member;
import com.example.Web_prac.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final MemberService memberService;

    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/login.html")
    public String login(@RequestParam String userId) {

        Member user = memberService.findUser(userId);

        return "/members/login";
    }

    @GetMapping("/register.html")
    public String showRegisterPage() {
        return "/members/register"; // 회원가입 페이지를 보여줌
    }


    @PostMapping("/register")
    public String register(@RequestParam String userName,
                           @RequestParam String userId,
                           @RequestParam String userPw) {


        // 회원가입 정보의 유효성 검사
        if (userName == null || userId == null || userPw == null) {
            // 유효성 검사 실패 시 처리
            return "error-page"; // 예: 에러 페이지로 이동
        }

        // 회원가입 정보의 보안 처리 (예를 들어, 패스워드 암호화)

        // 회원가입 정보 저장
        memberService.save(userName, userId, userPw);

        return "redirect:/"; // 회원가입 성공 페이지로 리다이렉션
    }


}
