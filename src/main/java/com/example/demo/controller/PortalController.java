package com.example.demo.controller;

import com.example.demo.bean.Article;
import com.example.demo.bean.Question;
import com.example.demo.bean.User;
import com.example.demo.bean.Type;
import com.example.demo.service.IArticleService;
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
public class PortalController {
    @Autowired
    IArticleService articleService;
    @Autowired
    IUserService userService;
    @Autowired
    ITypeService typeService;
    @Autowired
    IQuestionService questionService;
    @RequestMapping("/portal_index/{uname}")
    public ModelAndView toIndex(@PathVariable String uname){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("portal_index");//视图
        List<Question> questions=questionService.getQuestion();
        mv.addObject("questions",questions);
        List<Article> articles=articleService.getArticles();
        List<Type> type=typeService.getTypeByRank();
        mv.addObject("articles",articles);
        User user=userService.getUserByUname(uname);
        mv.addObject("user",user);//数据
        mv.addObject("type",type);
        return mv;
    }
    @RequestMapping("/portal_index2")
    public ModelAndView toIndex2(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("portal_index2");//视图
        List<Article> articles=articleService.getArticles();
        List<Type> type=typeService.getTypeByRank();
        mv.addObject("articles",articles);
        mv.addObject("type",type);
        return mv;
    }


    @RequestMapping("/portal_article_type1/{uname}")
    public ModelAndView toType1(String uname){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("portal_article_type1");
        //获取分类列表
        List<Type> type=typeService.getTypeByRank();
        List<Article> articles=articleService.selectArticle1("1");
        User user=userService.getUserByUname(uname);
        mv.addObject("user",user);//数据
        mv.addObject("articles",articles);
        mv.addObject("type",type);
        return mv;
    }

    @RequestMapping("/portal_article_type2")
    public ModelAndView toType2(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("portal_article_type2");
        //获取分类列表
        List<Type> type=typeService.getTypeByRank();
        List<Article> articles=articleService.selectArticle2("2");
        mv.addObject("articles",articles);
        mv.addObject("type",type);
        return mv;
    }

    @RequestMapping("/portal_article_type3")
    public ModelAndView toType3(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("portal_article_type3");
        //获取分类列表
        List<Type> type=typeService.getTypeByRank();
        List<Article> articles=articleService.selectArticle3("3");
        mv.addObject("articles",articles);
        mv.addObject("type",type);
        return mv;
    }
    @RequestMapping("/portal_article_type4")
    public ModelAndView toType4(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("portal_article_type4");
        //获取分类列表
        List<Type> type=typeService.getTypeByRank();
        List<Article> articles=articleService.selectArticle4("4");
        mv.addObject("articles",articles);
        mv.addObject("type",type);
        return mv;
    }
}