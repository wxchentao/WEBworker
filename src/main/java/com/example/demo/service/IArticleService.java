package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.bean.Article;
import com.example.demo.bean.User;

import java.util.List;

public interface IArticleService {
    public void addArticle(Article article);
    public List<Article> getArticles();
    public int delete(Integer id);
    public Article getArticleById(Integer id);
    public int update(Article article);
    public List<Article> selectArticle1(String id);
    public List<Article> selectArticle2(String id);
    public List<Article> selectArticle3(String id);
    public List<Article> selectArticle4(String id);

    public List<Article> findArticlesByName(QueryWrapper<Article> wrapper);
}
