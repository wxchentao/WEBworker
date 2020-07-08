package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
public User getUserById(Integer id);
    public User startUserById(Integer id);
    public User stopUserById(Integer id);
    public List<User> selectUserSlur(Integer id);
    public List<User> selectUseradmin(Integer id);
    public List<User> selectUserteacher(Integer id);
    public User findUserByUnameAndUpass(String uname,String upass);
    public User findByMail(String email);

    public User selectByUname(String uname);

}
