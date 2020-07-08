package com.example.demo.dao;

import com.example.demo.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("mybatis")
public class UserDaoImpl implements IUserDao{
    @Override
    public void save(User user) {
        System.out.println("【添加用户mybatis】"+user.getUname());
    }

    @Override
    public User getUserById(Integer id) {
        System.out.println("【获取用户mybatis】"+id);
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }
}

