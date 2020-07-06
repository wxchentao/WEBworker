package com.example.demo.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.bean.Type;
import com.example.demo.bean.User;
import com.example.demo.mapper.TypeMapper;
import com.example.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springtest {
    @Autowired
    UserMapper userMapper;

    @Autowired
    TypeMapper typeMapper;

    @Test
    public void test01(){
        User user=userMapper.selectById(1);
        System.out.println(user);
    }
    @Test
    public void test02(){
        User user=userMapper.selectById(2);
        System.out.println(user);
    }
//    @Test
//    public void test03(){
//        //添加用户
//        User user=new User(null,"testman","0701", headpic);
//        userMapper.insert(user);
//    }
    @Test
    public void test04(){
        List<User> list=userMapper.selectList(null);
        for(User u:list){
            System.out.println(u);
        }
    }

    @Test
    public void test14(){
        List<Type> list=typeMapper.selectList(null);
        for(Type u:list){
            System.out.println(u);
        }
    }

    @Test
    public void test05(){
        QueryWrapper<User>wrapper=new QueryWrapper<>();
        wrapper.eq("uname","testman");
        List<User> list =userMapper.selectList(wrapper);
        for(User u:list){
            System.out.println(u);
        }
    }
    @Test
    public void test06(){
        User user=userMapper.getUserById(1);
        System.out.println(user);
    }
@Test
    public void test16(){
        User user=userMapper.stopUserById(2);
        System.out.println(user);
    }

    @Test
    public void test17(){
        User user=userMapper.startUserById(2);
        System.out.println(user);
    }
    @Test
    public void test07(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("id", "4");
        //DocSet s = docSetService.getOne(queryWrapper);
        //docSetService.updateById(s);
        User user = new User();
        user.setUname("小鸟");
        userMapper.update(user,queryWrapper);
        System.out.println("第一次更新》》》》》》》》》》》》》》》》》》》》》》");
    }
    @Test
    public void test08() {

        // 1.根据ID删除一个员工
        Integer result = userMapper.deleteById(15);

        if (result != null || result > 0) {
            System.out.println("++++++++++++++++删除成功+++++");
        }

    }
}
