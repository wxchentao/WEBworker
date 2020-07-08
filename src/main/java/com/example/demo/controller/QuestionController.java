package com.example.demo.controller;

import com.example.demo.Result.Result;
import com.example.demo.Result.ResultUtils;
import com.example.demo.bean.Comment;
import com.example.demo.bean.Question;
import com.example.demo.bean.User;
import com.example.demo.service.ICommentService;
import com.example.demo.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@SuppressWarnings("ALL")
@RestController
public class QuestionController {
    @Autowired
    IQuestionService questionService;

    @Autowired
    ICommentService commentService;

    @RequestMapping("/question/manage")
    public ModelAndView toList1() {
        ModelAndView mv = new ModelAndView();
        System.out.println("进入登录");
        mv.setViewName("question_manage");
        return mv;
    }

    @RequestMapping("/getQuestion")
    public Result getQuestion() {
        Result result = null;
        List<Question> list = questionService.getQuestion();
        result = ResultUtils.success(list);
        result.setCode(0);
        result.setMsg("查询成功");
        return result;
    }

    @RequestMapping("/question/toAdd")
    public ModelAndView toAdd() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("question_add");
        return mv;
    }

    @RequestMapping("/question/add")
    public Result add(Question question) {
        System.out.println("添加数据【" + question + "】");
        questionService.addQuestion(question);
        Result result = null;
        result = ResultUtils.success(question);
        result.setCode(0);
        result.setMsg("添加成功");
        return result;
    }

    @RequestMapping("/question/toEdit/{id}")
    public ModelAndView toEdit(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("question_edit");
        Question question = questionService.getQuestionById(id);
        //设置数据
        mv.addObject("question", question);
        return mv;
    }

    @RequestMapping("/question/edit")
    public Result edit(Question question) {
        Result result = null;
        //先获取原来对象的值
        Question u = questionService.getQuestionById(question.getId());
        u.setQtitle(question.getQtitle());
        u.setQwriter(question.getQwriter());
        u.setQarticle(question.getQarticle());
        u.setQtime(question.getQtime());
        u.setQtype(question.getQtype());
        u.setAttachment(question.getAttachment());

        /*u.setScontent(article.getScontent());
        u.setWriter(article.getWriter());
        u.setAtime(article.getAtime());
        u.setAtype(article.getAtype());
        u.setAttachment(article.getAttachment());*/
        u.setIsenabled(question.getIsenabled());
        int data = questionService.update(u);
        result = ResultUtils.success(data);
        if (data > 0) {
            result.setCode(0);
            result.setMsg("更新成功");
        } else {
            result.setMsg("更新失败");
        }
        return result;
    }

    @RequestMapping("/question/delete/{id}")
    public Result deleteUser(@PathVariable Integer id) {
        Result result = null;
        int data = questionService.delete(id);
        result = ResultUtils.success(data);
        if (data > 0) {
            result.setCode(0);
            result.setMsg("删除成功");
        } else {
            result.setMsg("删除失败");
        }
        return result;
    }
    @RequestMapping("/question/toView/{id}")
    public ModelAndView toView(@PathVariable Integer id){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("questoin_view");
        Question question1=questionService.getQuestionById(id);
        List<Comment> comments1=commentService.selectCommentsByid(id);
        //设置数据
        mv.addObject("question1",question1);
        mv.addObject("comments1",comments1);
        System.out.println(comments1);
        System.out.println(question1);
        return mv;
    }

    @RequestMapping("/question/view")
    public Result view(Question question) {
        Result result = null;
        //先获取原来对象的值
        Question u = questionService.getQuestionById(question.getId());
        u.setQtitle(question.getQtitle());
        u.setQwriter(question.getQwriter());
        u.setQarticle(question.getQarticle());
        int data = questionService.update(u);
        result = ResultUtils.success(data);
        if (data > 0) {
            result.setCode(0);
            result.setMsg("更新成功");
        } else {
            result.setMsg("更新失败");
        }
        return result;
    }
    

}
