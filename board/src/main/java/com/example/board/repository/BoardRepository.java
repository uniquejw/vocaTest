package com.example.board.repository;

import com.example.board.entity.WordBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<WordBoard, Integer> {

    @Query(value = "Select DISTINCT wc.cate_id From word_category wc where wc.cate_type = :cateType and wc.cate_day = :cateType and wc.cate_title = :cateTitle", nativeQuery = true)
    int cateIdByDto(String cateType, Integer cateDay, String cateTitle);
}
