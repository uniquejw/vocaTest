package com.example.board.repository;

import com.example.board.entity.WordBoard;
import com.example.board.entity.WordList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<WordList, Integer> {

}
