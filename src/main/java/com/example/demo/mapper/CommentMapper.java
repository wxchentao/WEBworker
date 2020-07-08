package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.Article;
import com.example.demo.bean.Comment;

import java.util.List;

public interface CommentMapper extends BaseMapper<Comment> {
    public List<Comment> selectCommentsByid(int id);
}
