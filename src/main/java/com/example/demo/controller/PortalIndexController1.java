package com.example.demo.controller;

import com.example.demo.bean.Question;
import com.example.demo.bean.Type;
import com.example.demo.bean.User;
import com.example.demo.service.IQuestionService;
import com.example.demo.service.ITypeService;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class PortalIndexController1 {
    @Autowired
    IQuestionService questionService;
    @Autowired
    IUserService userService;
    @Autowired
    ITypeService typeService;
    @RequestMapping("/portal_index1")
    public ModelAndView toIndex(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("portal_index1");
        List<Type> type=typeService.getTypeByRank();
        List<Question> questions=questionService.getQuestion();
        mv.addObject("questions",questions);
        mv.addObject("type",type);
        return mv;
    }
    @RequestMapping("/portal_index1/{uname}")
    public ModelAndView toView1(@PathVariable String uname){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("portal_index1");
        //User user=userService.getUserById(id);
        User user=userService.getUserByUname(uname);
        //mv.addObject("user",user);//数据
        //设置数据
        List<Question> questions=questionService.getQuestion();
        mv.addObject("questions",questions);
        mv.addObject("user",user);
        return mv;
    }
    @RequestMapping("/portal_index3")
    public ModelAndView toIndex1(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("portal_index3");
        List<Type> type=typeService.getTypeByRank();
        List<Question> questions=questionService.getQuestion();
        mv.addObject("questions",questions);
        mv.addObject("type",type);
        return mv;
    }
}
