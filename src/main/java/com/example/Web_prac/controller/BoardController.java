package com.example.Web_prac.controller;

import com.example.Web_prac.domain.Board;
import com.example.Web_prac.domain.Member;
import com.example.Web_prac.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class BoardController {



    private final BoardService boardService;

    @GetMapping("/")
    public String home(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession(false);

        model.addAttribute("list",boardService.boardList());

        // 로그인한 사용자가 아니라면 /으로 보낸다.
        if ( session == null) {
            return "/members/list";
        }

        Member loginMember = (Member)session.getAttribute("user");
        // 사용자가 없으면 null 처리 필요
        if(loginMember == null) {
            return "/members/list";
        }

        // loginHome : 로그인에 성공한 사람만이 볼 수 있는 화면
        model.addAttribute("member", loginMember);
        return "/members/list_afterLogin";


    }

    @GetMapping("/view")
    public String viewBoard(Model model, Long boardId) {
        boardService.viewCount(boardId);
        model.addAttribute("halo", boardService.getBoard(boardId));

        return "/members/view";
    }

    @GetMapping("/write.html")
    public String uploadBoardForm(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        // 로그인한 사용자가 아니라면 /으로 보낸다.
        if ( session == null) {
            return "redirect:/";
        }

        Member loginMember = (Member)session.getAttribute("user");
        // 사용자가 없으면 null 처리 필요
        if(loginMember == null) {
            return "redirect:/";
        }


        return "/members/write";
    }

    @PostMapping("/write.html")
    public String uploadBoard(Board board) {
        boardService.uploadBoard(board);
        return "redirect:/";
    }

    @GetMapping(value = "/edit.html")
    public String updateBoardForm(Model model, Long boardId) {
        model.addAttribute("edit", boardService.getBoard(boardId));

        return "/members/edit";
    }

    @PostMapping("/edit.html")
    public String updateBoard(Board board) {
        boardService.updateBoard(board);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteBoard(Long boardId) {
        boardService.deleteBoard(boardId);
        boardService.modifyBoardNumber(boardId);
        // 게시글 삭제 후 번호 수정
        return "redirect:/";
    }


    @GetMapping(value = "/login/loginForm.html")
    public String login_web() {
        return "/login/loginForm";
    }

    @GetMapping(value = "/list_afterLog.html")
    public String list_afterLog() {
        return "/members/list_afterLog";
    }

}
