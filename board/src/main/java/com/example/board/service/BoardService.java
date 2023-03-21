package com.example.board.service;

import com.example.board.dto.WordBoardDto;
import com.example.board.dto.WordCateDto;
import com.example.board.dto.WordListDto;
import com.example.board.entity.WordBoard;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.CateRepository;
import com.example.board.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;
    WordRepository wordRepository;
    CateRepository cateRepository;
    public List<WordBoardDto> list(){
        List boardDtoList = new ArrayList<>();
        for (int i = 0; i < boardRepository.findAll().size(); i++) {
            WordBoardDto boardDto= new WordBoardDto();
            boardDto.setBoardNo(boardRepository.findAll().get(i).getBoardId());
            boardDto.setTitle(boardRepository.findAll().get(i).getBoardTitle());
            boardDto.setContent(boardRepository.findAll().get(i).getBoardContent());
            boardDto.setWriter(boardRepository.findAll().get(i).getWriter());
            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }

    public WordBoardDto detail(int id){

        WordBoardDto boardDto = new WordBoardDto();

        boardDto.setBoardNo(boardRepository.findById(id).get().getBoardId());
        boardDto.setTitle(boardRepository.findById(id).get().getBoardTitle());
        boardDto.setContent(boardRepository.findById(id).get().getBoardContent());
        boardDto.setWriter(boardRepository.findById(id).get().getWriter());

        return boardDto;

    }

    public List<WordCateDto> cateList(){
        List cateLists = new ArrayList<>();
        for (int i = 0; i < boardRepository.findAll().size(); i++) {
            WordCateDto wordCateDto = new WordCateDto();
            wordCateDto.setCateType(cateRepository.findAll().get(i).getCateType());
            wordCateDto.setCateDay(cateRepository.findAll().get(i).getCateDay());
            wordCateDto.setCateTitle(cateRepository.findAll().get(i).getCateTitle());
            cateLists.add(wordCateDto);
        }
        return cateLists;
    }

    public List<WordListDto> wordList(WordCateDto wordCateDto){

        int id = boardRepository.cateIdByDto(wordCateDto.getCateType(), wordCateDto.getCateDay(), wordCateDto.getCateTitle());

        List wordLists = new ArrayList<>();

        for (int i = 0; i < wordRepository.findAllById(Collections.singleton(id)).size(); i++) {
            WordListDto wordListDto = new WordListDto();
            wordListDto.setWord(wordRepository.findAllById(Collections.singleton(id)).get(i).getWord());
            wordListDto.setKorean(wordRepository.findAllById(Collections.singleton(id)).get(i).getKoreanMeaning());
            wordLists.add(wordListDto);
        }

        return wordLists;

    }

    public void write(WordBoardDto boardDto) {

        WordBoard boardEntity = new WordBoard();
        boardEntity.setBoardId(boardDto.getBoardNo());
        boardEntity.setBoardTitle(boardDto.getTitle());
        boardEntity.setBoardContent(boardDto.getTitle());
        boardEntity.setWriter(boardDto.getWriter());
        boardRepository.save(boardEntity);

    }

}
