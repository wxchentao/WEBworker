package com.example.demo.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_type")
public class Type {
    @TableId(value = "id", type = IdType.AUTO)
    public Integer id;
    private String typename;
    private String atype;
    private int rank;
    private String html;


    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Type() {
    }

    public Type(Integer id, String typename, String atype, int rank, String html) {
        this.id = id;
        this.typename = typename;
        this.atype = atype;
        this.rank = rank;
        this.html = html;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getAtype() {
        return atype;
    }

    public void setAtype(String atype) {
        this.atype = atype;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }


    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                ", atype='" + atype + '\'' +
                ", rank=" + rank +
                ", html='" + html + '\'' +
                '}';
    }
}