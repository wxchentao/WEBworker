package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.Article;

import java.util.List;

public interface ArticleMapper extends BaseMapper<Article> {
    public List<Article> selectArticle1(String id);
    public List<Article> selectArticle2(String id);
    public List<Article> selectArticle3(String id);
    public List<Article> selectArticle4(String id);
}
