package com.example.demo.service;

import com.example.demo.bean.Question;
import com.example.demo.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements IQuestionService {
   @Autowired
   QuestionMapper questionMapper;

    @Override
    public void addQuestion(Question question) {
        questionMapper.insert(question);
    }

    @Override
    public List<Question> getQuestion() {
        List<Question> list=questionMapper.selectList(null);
        return list;
    }

    @Override
    public int delete(Integer id) {
        return questionMapper.deleteById(id);
    }

    @Override
    public Question getQuestionById(Integer id) {
        Question question=questionMapper.selectById(id);
        return question;
    }

    @Override
    public int update(Question question) {
        int result=questionMapper.updateById(question);
        return result;
    }


}
