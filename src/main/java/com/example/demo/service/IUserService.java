package com.example.demo.service;

import com.example.demo.bean.User;

import java.util.List;

public interface IUserService {
    public void addUser(User user);
    public User login(User user);
    public List<User> getUsers();
    public int delete(Integer id);
    public User getUserById(Integer id);
    public User getUserByMail(String email);
    public int update(User user);
    public User stopUserById(Integer id);

    public User startUserById(Integer id);
    public List<User> selectUserSlur(Integer id);
    public List<User> selectUseradmin(Integer id);
    public List<User> selectUserteacher(Integer id);



}
