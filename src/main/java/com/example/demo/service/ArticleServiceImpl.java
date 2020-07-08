package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.bean.Article;
import com.example.demo.bean.User;
import com.example.demo.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService{
//    @Autowired
//@Qualifier(value ="mybatis")
//    IUserDao userDao;
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public void addArticle(Article article) {
        articleMapper.insert(article);
    }



    @Override
    public List<Article> getArticles() {
        List<Article> list=articleMapper.selectList(null);
        return list;
    }
    @Override
    public int delete(Integer id) {
        return articleMapper.deleteById(id);
    }

    @Override
    public Article getArticleById(Integer id) {
        Article article=articleMapper.selectById(id);
        return article;
    }

    @Override
    public int update(Article article) {
        int result=articleMapper.updateById(article);
        return result;
    }
    public List<Article> selectArticle1(String id){
        List<Article> list=(List<Article>) articleMapper.selectArticle1(id);
        return list;
    }

    @Override
    public List<Article> selectArticle2(String id) {
        List<Article> list=(List<Article>) articleMapper.selectArticle2(id);
        return list;
    }

    @Override
    public List<Article> selectArticle3(String id) {
        List<Article> list=(List<Article>) articleMapper.selectArticle3(id);
        return list;
    }
    @Override
    public List<Article> selectArticle4(String id) {
        List<Article> list=(List<Article>) articleMapper.selectArticle4(id);
        return list;
    }

    @Override
    public List<Article> findArticlesByName(QueryWrapper<Article> wrapper) {
        return articleMapper.selectList(wrapper);
    }
}
