package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.Question;
import com.example.demo.bean.User;

public interface QuestionMapper extends BaseMapper<Question> {
    public User getQuestoinById(Integer id);
}
