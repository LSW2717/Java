package com.example.projectboardapp.service;

import com.example.projectboardapp.dto.BoardRequestDto;
import com.example.projectboardapp.dto.BoardResponseDto;
import com.example.projectboardapp.entity.Board;
import com.example.projectboardapp.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor

public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardResponseDto> getPosts() {
        // DB의 Board 테이블에 접근해서 조회
        // select * from board
        List<BoardResponseDto> responseDtoList = new ArrayList<>();
        List<Board> boardList = boardRepository.findAll();
        for (Board board : boardList){
            responseDtoList.add(new BoardResponseDto(board));
        }
        return responseDtoList;
    }

    public BoardResponseDto savePost(BoardRequestDto requestDto) {
        // DTO -> Entity
        Board board = new Board(requestDto);
        Board saveBoard = boardRepository.save(board);
        return new BoardResponseDto(saveBoard);
    }
    @Transactional
    public BoardResponseDto updatePost(Long id, BoardRequestDto requestDto) {
        //select * from board where
        Board board = boardRepository.findById(id).orElseThrow(
            () -> new NullPointerException("해당 게시글 없음")
        );
        board.update(requestDto);
        //boardRepository.save(board);
        return new BoardResponseDto(board);
    }

    public void deletePost(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 게시글 없음")
        );
        boardRepository.delete(id);
    }
}
