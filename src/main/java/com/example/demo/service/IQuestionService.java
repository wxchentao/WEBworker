package com.example.demo.service;

import com.example.demo.bean.Question;

import java.util.List;

public interface IQuestionService {
    public void addQuestion(Question question);
    public List<Question> getQuestion();
    public int delete(Integer id);
    public Question getQuestionById(Integer id);
    public int update(Question question);
}
