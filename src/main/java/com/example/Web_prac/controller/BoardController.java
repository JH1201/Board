package com.example.Web_prac.controller;

import com.example.Web_prac.domain.Board;
import com.example.Web_prac.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("list",boardService.boardList());

        return "/members/list";
    }

    @GetMapping("/view")
    public String viewBoard(Model model, Long boardId) {
        boardService.viewCount(boardId);
        model.addAttribute("halo", boardService.getBoard(boardId));

        return "/members/view";
    }

    @GetMapping("/write.html")
    public String uploadBoardForm(Long boardId) {
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
