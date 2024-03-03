package com.example.Web_prac.controller;

import com.example.Web_prac.domain.Member;
import com.example.Web_prac.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {


    private final MemberService memberService;

    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/login")
    public String login() {
        return "/members/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String userId,
                        @RequestParam String userPw,
                        HttpServletRequest request,
                        RedirectAttributes redirectAttributes) {

        Member user = memberService.checkUser(userId);

        if(user == null) {
            return "/members/login";
        }


        if(user.getUserPw().equals(userPw)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(1800); // Session이 30분동안 유지

            return "redirect:/";

        }

        else {
            return "/members/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            System.out.println("session = " + session);

            //session.removeAttribute("user");
            session.invalidate();

        }


        return "redirect:/";
    }


    @GetMapping("/register")
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
