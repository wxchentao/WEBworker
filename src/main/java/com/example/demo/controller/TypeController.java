package com.example.demo.controller;

import com.example.demo.Result.Result;
import com.example.demo.Result.ResultUtils;
import com.example.demo.bean.Type;
import com.example.demo.bean.User;
import com.example.demo.service.ITypeService;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeController {
    @Autowired
    ITypeService typeService;

    @RequestMapping("/getTypes")
    public Result getTypes(){
        Result result=null;
        List<Type> list=typeService.getTypes();
        result= ResultUtils.success(list);
        result.setCode(0);
        result.setMsg("查询成功");
        return result;
    }
}
