package com.example.demo.service;

import com.example.demo.bean.Comment;
import com.example.demo.bean.Question;

import java.util.List;

public interface ICommentService {
    public void addComment(Comment comment);
    public List<Comment> getComment();
    public List<Comment> selectCommentsByid(Integer id);
    public int delete(Integer id);
    public Comment getCommentById(Integer id);
    public int update(Comment comment);

}
