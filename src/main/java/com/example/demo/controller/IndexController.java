package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
    @Autowired
    IUserService userService;
    @RequestMapping("/index/{uname}")
    public ModelAndView toIndex(@PathVariable String uname){
       ModelAndView mv=new ModelAndView();
       mv.setViewName("index");//视图
       User user=userService.getUserByUname(uname);
       mv.addObject("user",user);//数据
       return mv;
    }

    @RequestMapping("/welcome")
    public ModelAndView toWelcome(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("welcome");
        return mv;
    }
}
