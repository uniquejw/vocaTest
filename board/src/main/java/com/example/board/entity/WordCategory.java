package com.example.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class WordCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cateId;
    private String cateType;
    private int cateDay;
    private String cateTitle;
}
