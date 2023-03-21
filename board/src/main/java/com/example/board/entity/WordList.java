package com.example.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class WordList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer wordId;
    private Integer wordBoardId;
    private String wordTitle;
    private String word;
    private String koreanMeaning;
}
