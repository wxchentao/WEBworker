package com.example.demo.dao;

import com.example.demo.bean.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
public interface IUserDao {
    public void save(User user);
    public User getUserById(Integer id);
    public List<User> getUsers();
}
