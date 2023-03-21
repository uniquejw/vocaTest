package com.example.board.repository;

import com.example.board.entity.WordCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CateRepository extends JpaRepository<WordCategory, Integer> {

}
