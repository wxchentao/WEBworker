package com.example.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.example.demo.Result.Result;
import com.example.demo.Result.ResultUtils;
import com.example.demo.bean.Article;
import com.example.demo.bean.User;
import com.example.demo.service.IArticleService;
import com.sun.deploy.nativesandbox.NativeSandboxBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;


@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    IArticleService articleService;


    @RequestMapping("/list")
    public ModelAndView toList(){
        ModelAndView mv=new ModelAndView();
        System.out.println("进入登录");
        mv.setViewName("article_list");
        return mv;
    }

    @RequestMapping("/getArticles")
    public Result getArticles(){
        Result result=null;
        List<Article> list=articleService.getArticles();
        result=ResultUtils.success(list);
        result.setCode(0);
        result.setMsg("查询成功");
        return result;
    }


    @RequestMapping("/toAdd")
    public ModelAndView toAdd(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("article_add");
        return mv;
    }

    @RequestMapping("/add")
    public Result add(Article article){
        System.out.println("添加数据【"+article+"】");
        articleService.addArticle(article);
        Result result=null;
        result= ResultUtils.success(article);
        result.setCode(0);
        result.setMsg("添加成功");
        return result;
    }

    @RequestMapping("/delete/{id}")
    public Result deleteArticle(@PathVariable Integer id){
        Result result=null;
        int data=articleService.delete(id);
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

    @RequestMapping("/toEdit/{id}")
    public ModelAndView toEdit(@PathVariable Integer id){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("article_edit");
        Article article=articleService.getArticleById(id);
        //设置数据
        mv.addObject("article",article);
        return mv;
    }
    @RequestMapping("/edit")
    public Result edit(Article article){
        Result result=null;
        //先获取原来对象的值
        Article u=articleService.getArticleById(article.getId());
        u.setTitle(article.getTitle());
        u.setScontent(article.getScontent());
        u.setWriter(article.getWriter());
        u.setAtime(article.getAtime());
        u.setAtype(article.getAtype());
        u.setAttachment(article.getAttachment());
        u.setIsenabled(article.getIsenabled());
        int data= articleService.update(u);
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


    @RequestMapping(value="/uploadconimage",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> uploadconimage(HttpServletRequest request, @RequestParam MultipartFile file) {
        Map<String,Object> mv=new HashMap<String, Object>();
        Map<String,String> mvv=new HashMap<String, String>();
        try {
            String rootPath = request.getSession().getServletContext().getRealPath("/image/");
            Calendar date = Calendar.getInstance(); //Calendar.getInstance()是获取一个Calendar对象并可以进行时间的计算，时区的指定
            String originalFile = file.getOriginalFilename(); //获得文件最初的路径
            String uuid = UUID.randomUUID().toString();    //UUID转化为String对象
            String newfilename=date.get(Calendar.YEAR)+""+(date.get(Calendar.MONTH)+1)+""+date.get(Calendar.DATE)+uuid.replace("-", "")+originalFile;
            //得到完整路径名
            File newFile = new File(rootPath+newfilename);
            /*文件不存在就创建*/
            if(!newFile.getParentFile().exists()){
                newFile.getParentFile().mkdirs();
            }
            String filename=originalFile.substring(0, originalFile.indexOf("."));
            System.out.println(originalFile);
            System.out.println(filename);
            file.transferTo(newFile);
            System.out.println("newFile : "+newFile);
            String urlpat= "/image/"+ newfilename;
            mvv.put("src", urlpat);
            mvv.put("title",newfilename);
            mv.put("code", 0);
            mv.put("msg", "上传成功");
            mv.put("data", mvv);
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            mv.put("success", 1);
            return mv;
        }
    }
    @RequestMapping("/toView/{id}")
    public ModelAndView toView(@PathVariable Integer id){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("article_view");
        Article article=articleService.getArticleById(id);
        //设置数据
        mv.addObject("article",article);
        return mv;
    }
    @RequestMapping("/view")
    public Result view(Article article){
        Result result=null;
        //先获取原来对象的值
        Article u=articleService.getArticleById(article.getId());
        u.setTitle(article.getTitle());
        u.setScontent(article.getScontent());
        u.setWriter(article.getWriter());
        u.setAtime(article.getAtime());
        u.setAtype(article.getAtype());
        u.setAttachment(article.getAttachment());
        u.setIsenabled(article.getIsenabled());
        int data= articleService.update(u);
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
    @RequestMapping("/article_type1")
    public ModelAndView toArticle_type1(){
        ModelAndView mv=new ModelAndView();
        System.out.println("进入登录");
        mv.setViewName("article_type1");
        return mv;
    }
    @RequestMapping("/getArticle_type1")
    public Result getArticle_type1(){
        Result result=null;
        List<Article> list=articleService.selectArticle1("1");
        result=ResultUtils.success(list);
        result.setCode(0);
        result.setMsg("查询成功");
        return result;
    }
    @RequestMapping("/article_type2")
    public ModelAndView toArticle_type2(){
        ModelAndView mv=new ModelAndView();
        System.out.println("进入登录");
        mv.setViewName("article_type2");
        return mv;
    }
    @RequestMapping("/getArticle_type2")
    public Result getArticle_type2(){
        Result result=null;
        List<Article> list=articleService.selectArticle2("2");
        result=ResultUtils.success(list);
        result.setCode(0);
        result.setMsg("查询成功");
        return result;
    }
    @RequestMapping("/article_type3")
    public ModelAndView toArticle_type3(){
        ModelAndView mv=new ModelAndView();
        System.out.println("进入登录");
        mv.setViewName("article_type3");
        return mv;
    }
    @RequestMapping("/getArticle_type3")
    public Result getArticle_type3(){
        Result result=null;
        List<Article> list=articleService.selectArticle3("3");
        result=ResultUtils.success(list);
        result.setCode(0);
        result.setMsg("查询成功");
        return result;
    }
    @RequestMapping("/article_type4")
    public ModelAndView toArticle_type4(){
        ModelAndView mv=new ModelAndView();
        System.out.println("进入登录");
        mv.setViewName("article_type4");
        return mv;
    }
    @RequestMapping("/getArticle_type4")
    public Result getArticle_type4(){
        Result result=null;
        List<Article> list=articleService.selectArticle4("4");
        result=ResultUtils.success(list);
        result.setCode(0);
        result.setMsg("查询成功");
        return result;
    }

}
