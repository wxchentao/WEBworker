package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.bean.User;
import com.example.demo.dao.IUserDao;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
//    @Autowired
//@Qualifier(value ="mybatis")
//    IUserDao userDao;
    @Autowired
    UserMapper userMapper;
    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }
    @Override
    public User login(User user){
        User user2=userMapper.findUserByUnameAndUpass(user.getUname(),user.getUpass());
        if(user2.getId()>0) {
            return  user2;
        }
        else {
            return null;
        }
    }


    @Override
    public List<User> getUsers() {
        List<User> list=userMapper.selectList(null);
//        list.add(new User(1,"zhangsan","333"));
//        list.add(new User(2,"lisi","333"));
//        list.add(new User(3,"wangwu","333"));
//        list.add(new User(4,"zhaoliu","333"));
//        list.add(new User(5,"zhangqi","333"));
        return list;
    }

    @Override
    public int delete(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public User getUserById(Integer id) {
        User user=userMapper.selectById(id);
        return user;
    }



    @Override
    public int update(User user) {
        int result=userMapper.updateById(user);
        return result;
    }


    @Override
    public User stopUserById(Integer id) {

        return userMapper.stopUserById(id);
    }
    @Override
    public User startUserById(Integer id) {
        User user=userMapper.startUserById(id);
        return user;
    }
    public List<User> selectUserSlur(Integer id){
        List<User> list= (List<User>) userMapper.selectUserSlur(id);

        return list;
    }
    public List<User> selectUseradmin(Integer id){
        List<User> list=(List<User>) userMapper.selectUseradmin(id);
        return list;
    }
    public List<User> selectUserteacher(Integer id){
        List<User> list=(List<User>) userMapper.selectUserteacher(id);
        return list;
    }

    @Override
    public User getUserByMail(String email){
        User user=userMapper.findByMail(email);
        return user;
    }
    @Override
    public List<User> findUserByName(QueryWrapper wrapper)
    {
        return userMapper.selectList(wrapper);
    }

    @Override
    public User getUserByUname(String uname){
        User user=userMapper.selectByUname(uname);
        return user;
    }
}
