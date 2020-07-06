package com.example.demo.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_user")
public class User {
    @TableId(value = "id",type = IdType.AUTO )
    private Integer id;
    private String sno;
    private String uname;
    private String upass;
    private String headpic;
    private String email;
    private String isenabled;
    private String detail;
    private String role;
    public User(){

    }
    public User(Integer id, String sno, String uname, String upass, String headpic, String email, String isenabled, String detail, String role) {
        this.id = id;
        this.sno = sno;
        this.uname = uname;
        this.upass = upass;
        this.headpic = headpic;
        this.email = email;
        this.isenabled = isenabled;
        this.detail = detail;
        this.role = role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIsenabled() {
        return isenabled;
    }

    public void setIsenabled(String isenabled) {
        this.isenabled = isenabled;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", sno='" + sno + '\'' +
                ", uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                ", headpic='" + headpic + '\'' +
                ", email='" + email + '\'' +
                ", isenabled='" + isenabled + '\'' +
                ", detail='" + detail + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
