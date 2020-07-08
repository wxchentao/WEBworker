package com.example.demo.service;

import com.example.demo.bean.Article;
import com.example.demo.bean.Type;

import java.util.List;

public interface ITypeService {
    public void addType(Type type);
    public List<Type> getType();
    public int delete(Integer id);
    public Type getTypeById(int id);
    public List<Type> getTypeByRank();
    public int update(Type type);
}
