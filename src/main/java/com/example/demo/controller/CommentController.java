package com.example.demo.controller;

import com.example.demo.Result.Result;
import com.example.demo.Result.ResultUtils;
import com.example.demo.bean.Comment;
import com.example.demo.bean.Question;
import com.example.demo.service.ICommentService;
import com.example.demo.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.concurrent.Callable;

@RestController
public class CommentController {

    @Autowired
    IQuestionService questionService;

    @Autowired
    ICommentService commentService;

    @RequestMapping("/comment/list")
    public ModelAndView toList1() {
        ModelAndView mv = new ModelAndView();
        System.out.println("进入登录");
        mv.setViewName("comment_list");
        return mv;
    }

    @RequestMapping("/getComment")
    public Result getComment() {
        Result result = null;
        List<Comment> list =commentService.getComment();
        result = ResultUtils.success(list);
        result.setCode(0);
        result.setMsg("查询成功");
        return result;
    }

    @RequestMapping("/comment/toAdd")
    public ModelAndView toAdd() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("comment_add");
        return mv;
    }

    @RequestMapping("/comment/add")
    public Result add(Comment comment) {
        System.out.println("添加数据【" + comment + "】");
        commentService.addComment(comment);
        Result result = null;
        result = ResultUtils.success(comment);
        result.setCode(0);
        result.setMsg("添加成功");
        return result;
    }

    @RequestMapping("/comment/toEdit/{id}")
    public ModelAndView toEdit(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("comment_edit");
        Comment comment=commentService.getCommentById(id);
        //设置数据
        mv.addObject("comment", comment);
        return mv;
    }

    @RequestMapping("/comment/edit")
    public Result edit(Comment comment) {
        Result result = null;
        //先获取原来对象的值
        Comment u = commentService.getCommentById(comment.getId());
        u.setComment(comment.getComment());
        u.setUsername(comment.getUsername());
        u.setTime(comment.getTime());
        u.setQid(comment.getQid());
        int data = commentService.update(u);
        result = ResultUtils.success(data);
        if (data > 0) {
            result.setCode(0);
            result.setMsg("更新成功");
        } else {
            result.setMsg("更新失败");
        }
        return result;
    }
    @RequestMapping("/comment/delete/{id}")
    public Result deleteUser(@PathVariable Integer id) {
        Result result = null;
        int data = commentService.delete(id);
        result = ResultUtils.success(data);
        if (data > 0) {
            result.setCode(0);
            result.setMsg("删除成功");
        } else{
            result.setMsg("删除失败");
        }
        return result;
    }

}
