package com.example.projectboardapp.controller;

import com.example.projectboardapp.dto.BoardRequestDto;
import com.example.projectboardapp.dto.BoardResponseDto;
import com.example.projectboardapp.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/posts")
    public List<BoardResponseDto> getPosts() {
        return boardService.getPosts();
    }

    @PostMapping("/post")
    public BoardResponseDto savePost(@RequestBody BoardRequestDto requestDto) {
        return boardService.savePost(requestDto);
    }

    @PutMapping("/post/{id}")
    public BoardResponseDto updatePost(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
        return boardService.updatePost(id, requestDto);
    }

    @DeleteMapping("/post")
    public void deletePost(@RequestParam Long id){
        boardService.deletePost(id);
    }
}
