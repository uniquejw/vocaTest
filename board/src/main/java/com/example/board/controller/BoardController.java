package com.example.board.controller;

import com.example.board.dto.WordBoardDto;
import com.example.board.dto.WordCateDto;
import com.example.board.dto.WordListDto;
import com.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("list", boardService.list());
        return "list";
    }

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        model.addAttribute("detail", boardService.detail(id));
        return "/detail";
    }


    @RequestMapping("/toCreate")
    public String create(Model model){
        model.addAttribute("wordList", boardService.cateList());
        return "/create";
    }

    @RequestMapping("/inCreate")
    public String inCreate(WordCateDto wordCateDto, Model model){
        model.addAttribute("wordList", boardService.wordList(wordCateDto));
        model.addAttribute("wordList", boardService.cateList());
        return "/create";
    }

    @RequestMapping("/createTest")
    public String create(WordBoardDto boardDto, Model model) {
        boardService.write(boardDto);
        return "/list";
    }

    /*-----------------------------------------------------------*/
//    @RequestMapping("/wordList")
//    public String wordList(WordCateDto wordCateDto, Model model){
//        model.addAttribute("wordList", boardService.wordList(wordCateDto));
//        return "/create";
//    }
//
//    @RequestMapping("/cateList")
//    public String cateList(Model model){
//        model.addAttribute("wordList", boardService.cateList());
//        return "/create";
//    }


}
