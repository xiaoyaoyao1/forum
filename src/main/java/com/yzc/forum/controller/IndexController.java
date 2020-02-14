package com.yzc.forum.controller;


import com.yzc.forum.dto.PaginationDTO;
import com.yzc.forum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {


    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                        @RequestParam(name = "size",defaultValue = "5") Integer size){


        PaginationDTO pagination = questionService.list(page,size);
        model.addAttribute("pagination",pagination);
        return "index";
    }
}
