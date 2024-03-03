package com.example.Web_prac.mapper;

import com.example.Web_prac.domain.Board;
import com.example.Web_prac.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {


    int boardCount(); // 게시판 모든 글의 수
    Board getBoard(Long boardId);

    List<Board> getList();

    void uploadBoard(Board board); // 게시물 게시

    void updateBoard(Board board); // 게시물 수정

    void deleteBoard(Long boardId); // 게시물 삭제

    void modifyBoardNumber(Long boardId); // 게시물 삭제 시 게시물번호 수정

    void viewCount(Long boardId); // 조회수 증가
}
