package com.example.Web_prac.controller;


import com.example.Web_prac.domain.Member;
import com.example.Web_prac.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ProfileController {

    public final BoardService boardService;

    public ProfileController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/profile")
    public String profile() {

        return "/members/profile";


    }

}
