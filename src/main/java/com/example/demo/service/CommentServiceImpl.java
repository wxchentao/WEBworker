package com.example.demo.service;

import com.example.demo.bean.Comment;
import com.example.demo.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    CommentMapper commentMapper;
    @Override
    public void addComment(Comment comment) {
        commentMapper.insert(comment);
    }

    @Override
    public List<Comment> getComment() {
        List<Comment> list=commentMapper.selectList(null);
        return list;
    }

    @Override
    public List<Comment> selectCommentsByid(Integer id) {
        List<Comment> comments=commentMapper.selectCommentsByid(id);
       return comments;
    }
    @Override
    public int delete(Integer id) {
        return commentMapper.deleteById(id);
    }

    @Override
    public Comment getCommentById(Integer id) {
        Comment comment=commentMapper.selectById(id);
        return comment;
    }

    @Override
    public int update(Comment comment) {
        int result=commentMapper.updateById(comment);
        return result;
    }
}
