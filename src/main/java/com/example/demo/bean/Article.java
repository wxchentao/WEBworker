package com.example.demo.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("t_article")
public class Article {
    @TableId(value = "id",type = IdType.AUTO )
    private Integer id;
    private String title;
    private String scontent;
    private String writer;
    private Integer isenabled;

    private String atime;
    private String atype;
    private String attachment;
    public Article(){}
    public String getAtime() {
        return atime;
    }

    public void setAtime(String atime) {
        this.atime = atime;
    }


    public Article(Integer id, String title, String scontent, String writer, Integer isenabled, String atime, String atype, String attachment) {
        this.id = id;
        this.title = title;
        this.scontent = scontent;
        this.writer = writer;
        this.isenabled = isenabled;
        this.atime = atime;
        this.atype = atype;
        this.attachment = attachment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setScontent(String scontent) {
        this.scontent = scontent;
    }
    public String getScontent() {
        return scontent;
    }
    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", scontent='" + scontent + '\'' +
                ", atime='" + atime + '\'' +
                ", atype='" + atype + '\'' +
                ", attachment='" + attachment + '\'' +
                ", isenabled='" + isenabled + '\'' +
                '}';
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Integer getIsenabled() {
        return isenabled;
    }

    public void setIsenabled(Integer isenabled) {
        this.isenabled = isenabled;
    }

    public String getAtype() {
        return atype;
    }

    public void setAtype(String atype) {
        this.atype = atype;
    }
    public void setAttachment(String attachment){
        this.attachment=attachment;
    }
    public String getAttachment(){
        return attachment;
    }
}
