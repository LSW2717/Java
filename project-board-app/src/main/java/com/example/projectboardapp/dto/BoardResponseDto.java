package com.example.projectboardapp.dto;

import com.example.projectboardapp.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {
    private Long id;
    private String title;
    private String author;
    private String contents;

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.author = board.getAuthor();
        this.contents = board.getContents();
    }
}
