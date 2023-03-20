package com.example.board.controller;

import com.example.board.dto.BoardDto;
import com.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("list", boardService.list());
        return "index";
    }

    @RequestMapping("/create")
    public String create(BoardDto boardDto, Model model){
        boardService.write(boardDto);
        return "list";
    }
}
