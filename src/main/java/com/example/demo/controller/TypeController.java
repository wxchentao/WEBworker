package com.example.demo.controller;

import com.example.demo.Result.Result;
import com.example.demo.Result.ResultUtils;
import com.example.demo.bean.Type;
import com.example.demo.bean.User;
import com.example.demo.service.ITypeService;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    ITypeService typeService;
    @RequestMapping("/add")
    public Result add(Type type){
        System.out.println("添加数据【"+type+"】");
        typeService.addType(type);
        Result result=null;
        result= ResultUtils.success(type);
        result.setCode(0);
        result.setMsg("添加成功");
        return result;
    }

    @RequestMapping("/getType")
    public Result getType(){
        Result result=null;
        List<Type> list=typeService.getType();
        result=ResultUtils.success(list);
        result.setCode(0);
        result.setMsg("查询成功");
        return result;
    }
    @RequestMapping("/list")
    public ModelAndView toList(){
        ModelAndView mv=new ModelAndView();
        System.out.println("分类管理");
        mv.setViewName("type_list");
        return mv;
    }
    @RequestMapping("/delete/{id}")
    public Result deleteUser(@PathVariable Integer id){
        Result result=null;
        int data=typeService.delete(id);
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
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("type_add");
        return mv;
    }
    @RequestMapping("/edit")
    public Result edit(Type type){
        Result result=null;
        //先获取原来对象的值
        Type t=typeService.getTypeById(type.getId());
        t.setId(type.getId());
        t.setTypename(type.getTypename());
        t.setAtype(type.getAtype());
        t.setRank(type.getRank());
        int data= typeService.update(t);
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
    @RequestMapping("/toEdit/{id}")
    public ModelAndView toEdit(@PathVariable Integer id){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("type_edit");
        Type type=typeService.getTypeById(id);
        //设置数据
        mv.addObject("type",type);
        return mv;
    }
}