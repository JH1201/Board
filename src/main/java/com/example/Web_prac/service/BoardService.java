package com.example.Web_prac.service;

import com.example.Web_prac.domain.Board;
import com.example.Web_prac.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // 서비스 역할을 하는 것임을 명시
@RequiredArgsConstructor // Mapper 생성자를 사용할 수 있게 함
@Transactional(readOnly = true)
public class BoardService {
    private final BoardMapper boardMapper;
    public int boardCount() {
        return boardMapper.boardCount(); // 게시글 수 반환
    }

    public Board getBoard(Long boardId) {
        return boardMapper.getBoard(boardId);
    }

    public List<Board> boardList() {
        return boardMapper.getList(); // 게시글 리스트 반환
    }

    @Transactional
    public void uploadBoard(Board board) {
        Long num = (long) boardCount() + 1;
        board.setBoardId(num);
        boardMapper.uploadBoard(board);
    }

    @Transactional
    public void updateBoard(Board board) {
        boardMapper.updateBoard(board);
    }

    @Transactional
    public void deleteBoard(Long boardId) {
        // 게시글 삭제
        boardMapper.deleteBoard(boardId);
    }

    public void modifyBoardNumber(Long boardId) {
        boardMapper.modifyBoardNumber(boardId);
    }

    public void viewCount(Long boardId) {
        boardMapper.viewCount(boardId);
    }
}