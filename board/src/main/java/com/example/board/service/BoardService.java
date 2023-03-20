package com.example.board.service;

import com.example.board.dto.BoardDto;
import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    public List<BoardDto> list(){
        List boardDtoList = new ArrayList<>();
        for (int i = 0; i < boardRepository.findAll().size(); i++) {
            BoardDto boardDto= new BoardDto();
            boardDto.setBoardNo(boardRepository.findAll().get(i).getBoardNum());
            boardDto.setTitle(boardRepository.findAll().get(i).getBoardTitle());
            boardDto.setContent(boardRepository.findAll().get(i).getBoardContent());
            boardDto.setWriter(boardRepository.findAll().get(i).getWriter());
            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }

    public void write(BoardDto boardDto) {
        Board boardEntity = new Board();
        boardEntity.setBoardNum(boardDto.getBoardNo());
        boardEntity.setBoardTitle(boardDto.getTitle());
        boardEntity.setBoardContent(boardDto.getTitle());
        boardEntity.setWriter(boardDto.getWriter());
        boardRepository.save(boardEntity);
    }
}
