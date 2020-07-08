package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo.Result.Result;
import com.example.demo.Result.ResultEnum;
import com.example.demo.Result.ResultUtils;
import com.example.demo.bean.User;
import com.example.demo.service.IUserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @RestController=@Controller+@ResponseBody
 * @Controller 用于表示控制器类
 * @ResponseBody 返回的对象结果会被转为Json格式数据
 * */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    /* @RequestMapping 映射路径*/
    @RequestMapping("/doLogin")
    public Result login(String uname, String upass) {
        Result result = null;
        System.out.println("执行登陆.....");
        System.out.println("【用户名】" + uname + ",【密码】" + upass);
        User user = new User();
        user.setUname(uname);
        user.setUpass(upass);
        try {
            User loginUser = userService.login(user);
            if (loginUser != null && (loginUser.getRole()).endsWith("1")) {
                result = ResultUtils.success(user);
                result.setMsg(user.getUname());
            } else {
                result = ResultUtils.success(user);
                result.setCode(ResultEnum.LOGIN_FAILS.getCode());
                result.setMsg(ResultEnum.LOGIN_FAILS.getMsg());
            }
            return result;
        }catch (Exception e){
            result = ResultUtils.success(user);
            result.setCode(ResultEnum.LOGIN_FAILS.getCode());
            result.setMsg(ResultEnum.LOGIN_FAILS.getMsg());
            return result;
        }

    }
    @RequestMapping("/toLogin")
    public ModelAndView toLogin(){
        ModelAndView mv=new ModelAndView();
        System.out.println("进入登录");
        mv.setViewName("login");
        return mv;
    }
    @RequestMapping("/list")
    public ModelAndView toList(){
        ModelAndView mv=new ModelAndView();
        System.out.println("进入登录");
        mv.setViewName("user_list");
        return mv;
    }
    @RequestMapping("/stu_list")
    public ModelAndView toStu_list(){
        ModelAndView mv=new ModelAndView();
        System.out.println("进入登录");
        mv.setViewName("user_stu_list");
        return mv;
    }
    @RequestMapping("/admin_list")
    public ModelAndView toAdmin_list(){
        ModelAndView mv=new ModelAndView();
        System.out.println("进入登录");
        mv.setViewName("user_admin_list");
        return mv;
    }
    @RequestMapping("/teacher_list")
    public ModelAndView toTeacher_list(){
        ModelAndView mv=new ModelAndView();
        System.out.println("进入登录");
        mv.setViewName("user_teacher_list");
        return mv;
    }
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("user_add");
        return mv;
    }
    @RequestMapping("/toEdit/{id}")
    public ModelAndView toEdit(@PathVariable Integer id){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("user_edit");
        User user=userService.getUserById(id);
        //设置数据
        mv.addObject("user",user);
        mv.addObject("url","/user/"+user.getHeadpic());
        return mv;
    }
    @RequestMapping("/edit")
    public Result edit(User user){
        Result result=null;
        //先获取原来对象的值
        User u=userService.getUserById(user.getId());
        u.setUname(user.getUname());
        u.setHeadpic(user.getHeadpic());
        u.setDetail(user.getDetail());
        u.setEmail(user.getEmail());

        int data= userService.update(u);
        result=ResultUtils.success(data);
        if(data>0){
            result.setCode(0);
            result.setMsg("更新成功");
        }
        else{
            result.setMsg("更新失败");
        }
        return result;
    }
    @RequestMapping("/add")
    public Result add(User user){
        System.out.println("添加数据【"+user+"】");
        userService.addUser(user);
        Result result=null;
        result=ResultUtils.success(user);
        result.setCode(0);
        result.setMsg("添加成功");
        return result;
    }

//    @RequestMapping("/getUsers")
//    public Result getUsers(){
//        Result result=null;
//        List<User> list=userService.getUsers();
//        result=ResultUtils.success(list);
//        result.setCode(0);
//        result.setMsg("查询成功");
//        return result;
//    }
@RequestMapping("/getUsers")
public Result getUsers(@RequestParam(value="uname",required = false,defaultValue = "") String uname) {
    QueryWrapper<User> wrapper = new QueryWrapper();
    wrapper.like("uname", uname);
    List<User> list = userService.findUserByName(wrapper);
    Result result = null;
    result = ResultUtils.success(list);
    result.setData(list);
    result.setCode(0);
    result.setMsg("查询成功");
    return result;
}
//public Result getUsers(){
//    Result result=null;
//    List<User> list=userService.getUsers();
//    result=ResultUtils.success(list);
//    result.setCode(0);
//    result.setMsg("查询成功");
//    return result;
//}
    @RequestMapping("/getStu_list")
    public Result getStu_list(){
        Result result=null;
        List<User> list=userService.selectUserSlur(1);
        result=ResultUtils.success(list);
        result.setCode(0);
        result.setMsg("查询成功");
        return result;
    }
    @RequestMapping("/getAdmin_list")
    public Result getAdmin_list(){
        Result result=null;
        List<User> list=userService.selectUseradmin(2);
        result=ResultUtils.success(list);
        result.setCode(0);
        result.setMsg("查询成功");
        return result;
    }
    @RequestMapping("/getTeacher_list")
    public Result getTeacher_list(){
        Result result=null;
        List<User> list=userService.selectUserteacher(3);
        result=ResultUtils.success(list);
        result.setCode(0);
        result.setMsg("查询成功");
        return result;
    }
    @RequestMapping("/delete/{id}")
    public Result deleteUser(@PathVariable Integer id){
        Result result=null;
        int data=userService.delete(id);
        result=ResultUtils.success(data);
        if(data>0){
            result.setCode(0);
            result.setMsg("删除成功");
        }
        else{
            result.setMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("/stop/{id}")
    public Result stopUser(@PathVariable Integer id){
        Result result=null;
        System.out.println(id);
        System.out.println("更改状态");
        userService.stopUserById(id);
        result=ResultUtils.success(id);
        result.setCode(0);
        result.setMsg("暂停"+id+"号成员，状态成功");
        return result;
    }

    @RequestMapping("/start/{id}")
    public Result startUser(@PathVariable Integer id){
        Result result=null;
        System.out.println(id);
        System.out.println("更改状态");
        userService.startUserById(id);
        result=ResultUtils.success(id);
        result.setCode(0);
        result.setMsg("启动"+id+"号成员，状态成功");
        return result;
    }



    @RequestMapping("/uploadHeadPic")
    public Result uploadHeadPic(@RequestParam("file") MultipartFile file) throws IOException {
        // 项目路径
        File projectPath = new File(ResourceUtils.getURL("classpath:").getPath());
        System.out.println("projectPath="+projectPath);
        // 绝对路径=项目路径+自定义路径
        File upload = new File(projectPath.getAbsolutePath(), "static/user/");
        if (!upload.exists())
            upload.mkdirs();
        Result result=null;
        if (file.isEmpty()) {
            result=ResultUtils.error(-1,"上传失败");
        }
        else{
            //获取文件名称
            String fileName=file.getOriginalFilename();
            System.out.println("dest="+upload.getAbsolutePath()+"\\"+fileName);
            File dest=new File(upload.getAbsolutePath()+"\\"+fileName);
            //文件IO
            file.transferTo(dest);
            result=ResultUtils.success();
            result.setCode(0);
            result.setMsg("上传成功");
            Map<String,String> map=new HashMap<>();
            map.put("src",fileName);
            result.setData(map);
        }

        return result;
    }
    @RequestMapping("/toView/{id}")
    public ModelAndView toView(@PathVariable Integer id){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("user_view");
        User user=userService.getUserById(id);
        //设置数据
        mv.addObject("user",user);
        mv.addObject("url","/user/"+user.getHeadpic());
        return mv;
    }
    @RequestMapping("/toView2/{id}")
    public ModelAndView toView2(@PathVariable Integer id){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("user_view2");
        User user=userService.getUserById(id);
        //设置数据
        mv.addObject("user",user);
        mv.addObject("url","/user/"+user.getHeadpic());
        return mv;
    }
    @RequestMapping("/toView3/{id}")
    public ModelAndView toView3(@PathVariable Integer id){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("user_edit2");
        User user=userService.getUserById(id);
        //设置数据
        mv.addObject("user",user);
        mv.addObject("url","/user/"+user.getHeadpic());
        return mv;
    }
    @RequestMapping("/view")
    public Result view(User user){
        Result result=null;
        //先获取原来对象的值
        User u=userService.getUserById(user.getId());
        u.setUname(user.getUname());
        u.setHeadpic(user.getHeadpic());
        u.setDetail(user.getDetail());
        u.setEmail(user.getEmail());
        int data= userService.update(u);
        result=ResultUtils.success(data);
        if(data>0){
            result.setCode(0);
            result.setMsg("更新成功");
        }
        else{
            result.setMsg("更新失败");
        }
        return result;
    }
    //    前端登录
    @RequestMapping("/doPortal_login")
    public Result portal_login(String uname, String upass, HttpSession session) {
        Result result = null;
        System.out.println("执行前端用户登陆.....");
        System.out.println("【用户名】" + uname + ",【密码】" + upass);
        User user = new User();
        user.setUname(uname);
        user.setUpass(upass);
        session.setAttribute("sessionuser",user);
        try {
            User loginUser = userService.login(user);
            if (loginUser != null && ((loginUser.getRole()).endsWith("2") || (loginUser.getRole()).endsWith("3"))) {
                result = ResultUtils.success(user);
                result.setMsg(user.getUname());
            } else {
                result = ResultUtils.success(user);
                result.setCode(ResultEnum.LOGIN_FAILS.getCode());
                result.setMsg(ResultEnum.LOGIN_FAILS.getMsg());
            }
            session.setAttribute("sessionuser",user);
            return result;
        }
        catch (Exception e){
            result = ResultUtils.success(user);
            result.setCode(ResultEnum.LOGIN_FAILS.getCode());
            result.setMsg(ResultEnum.LOGIN_FAILS.getMsg());
            return result;
        }
    }


    @RequestMapping("/toPortal_login")
    public ModelAndView toPortal_login(){
        ModelAndView mv=new ModelAndView();
        System.out.println("进入前端登录");
        mv.setViewName("portal_login");
        return mv;
    }
    @RequestMapping("/toRegister")
    public ModelAndView toRegister(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("user_register");
        return mv;
    }
    @RequestMapping("/toFind")
    public ModelAndView toFind(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("user_find");
        return mv;
    }
    @RequestMapping("/doMail_login")
    public Result portal_login(String email) {
        Result result = null;
        System.out.println("执行前端用户登陆.....");
        System.out.println("【邮箱】" + email );
        User user = userService.getUserByMail(email);
        User loginUser = userService.login(user);
        if (loginUser != null && ((loginUser.getRole()).endsWith("2") || (loginUser.getRole()).endsWith("3"))) {
            result = ResultUtils.success(user);
            result.setMsg(user.getUname());
        } else {
            result = ResultUtils.success(user);
            result.setCode(ResultEnum.LOGIN_FAILS.getCode());
            result.setMsg(ResultEnum.LOGIN_FAILS.getMsg());
        }
        return result;
    }
//    @RequestMapping("/getlist")
//    public Result getList(@RequestParam(value="uname",required = false,defaultValue = "") String uname){
//        QueryWrapper<User> wrapper=new QueryWrapper();
//        wrapper.like("uname",uname);
//        List<User> list=userService.findUserByName(wrapper);
//        Result result=null;
//        result=ResultUtils.success(list);
//        result.setData(list);
//        result.setCode(0);
//        result.setMsg("查询成功");
//        return result;
//
//    }
@RequestMapping("/BarGraph")
public ModelAndView userBarGraph(){
    ModelAndView mv=new ModelAndView();
    System.out.println("查看图标");
    mv.setViewName("userBarGraph");
    return mv;
}
    @RequestMapping("/toRegister2")
    public ModelAndView toRegister2(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("user_register2");
        return mv;
    }
    @RequestMapping("/toEdit2/{id}")
    public ModelAndView toEdit2(@PathVariable Integer id){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("user_edit3");
        User user=userService.getUserById(id);
        //设置数据
        mv.addObject("user",user);
        mv.addObject("url","/user/"+user.getHeadpic());
        return mv;
    }
}