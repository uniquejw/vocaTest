package com.example.board.controller;

import com.example.board.dto.BoardDto;
import com.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String detail(@PathVariable("id") int id, Model model){
        System.out.println(id);
        model.addAttribute("detail", boardService.detail(id));
        return "/detail";
    }

    @RequestMapping("/create")
    public String create(BoardDto boardDto, Model model){
        boardService.write(boardDto);
        return "list";
    }
}
