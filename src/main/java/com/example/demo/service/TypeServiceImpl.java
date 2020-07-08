package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.bean.Type;
import com.example.demo.bean.User;
import com.example.demo.mapper.TypeMapper;
import net.sf.jsqlparser.statement.select.OrderByElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

@Service
public class TypeServiceImpl implements ITypeService{
    @Autowired
    TypeMapper typeMapper;
    @Override
    public void addType(Type type) {
        typeMapper.insert(type);
    }

    @Override
    public List<Type> getType() {
        List<Type> list=typeMapper.selectList(null);
        return list;
    }

    @Override
    public int delete(Integer id) {
        return typeMapper.deleteById(id);
    }

    @Override
    public Type getTypeById(int id) {
        Type type=typeMapper.selectById(id);
        return type;
    }

    @Override
    public List<Type> getTypeByRank() {
        List<Type> list=typeMapper.selectList(new QueryWrapper<Type>().orderByAsc("rank"));
        return list;
    }


    @Override
    public int update(Type type) {
        int result=typeMapper.updateById(type);
        return result;
    }
}
