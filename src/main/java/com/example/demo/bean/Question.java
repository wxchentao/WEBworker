package com.example.demo.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.stereotype.Component;

@Component

@TableName("t_question1")
public class Question {
    @TableId(value = "id",type = IdType.AUTO )
    private Integer id;
    private String qtitle;
    private String qwriter;
    private String qarticle;
    private String qtime;
    private String qtype;
    private String attachment;
    private Integer isenabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQtitle() {
        return qtitle;
    }

    public void setQtitle(String qtitle) {
        this.qtitle = qtitle;
    }

    public String getQwriter() {
        return qwriter;
    }

    public void setQwriter(String qwriter) {
        this.qwriter = qwriter;
    }

    public String getQarticle() {
        return qarticle;
    }

    public void setQarticle(String qarticle) {
        this.qarticle = qarticle;
    }

    public String getQtime() {
        return qtime;
    }

    public void setQtime(String qtime) {
        this.qtime = qtime;
    }

    public String getQtype() {
        return qtype;
    }

    public void setQtype(String qtype) {
        this.qtype = qtype;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Integer getIsenabled() {
        return isenabled;
    }

    public void setIsenabled(Integer isenabled) {
        this.isenabled = isenabled;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", qtitle='" + qtitle + '\'' +
                ", qwriter='" + qwriter + '\'' +
                ", qarticle='" + qarticle + '\'' +
                ", qtime='" + qtime + '\'' +
                ", qtype='" + qtype + '\'' +
                ", attachment='" + attachment + '\'' +
                ", isenabled='" + isenabled + '\'' +
                '}';
    }


}
