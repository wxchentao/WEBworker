package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
    @RequestMapping("/index")
    public ModelAndView toIndex(){
       ModelAndView mv=new ModelAndView();
       mv.setViewName("index");
       return mv;
    }

    @RequestMapping("/welcome")
    public ModelAndView toWelcome(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("welcome");
        return mv;
    }
}
