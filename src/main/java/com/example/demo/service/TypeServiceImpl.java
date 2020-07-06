package com.example.demo.service;

import com.example.demo.bean.Type;
import com.example.demo.bean.User;
import com.example.demo.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeServiceImpl implements ITypeService{
    @Autowired
    TypeMapper typeMapper;

    @Override
    public List<Type> getTypes() {
        List<Type> list=typeMapper.selectList(null);
        return list;
    }

}
