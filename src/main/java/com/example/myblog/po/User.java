package com.example.myblog.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Data       // 用户表
public class User {
    @Id
    private Integer userId;
    private String userName;    // 用戶名
    private  String userPass;   //用户密码
    private String userEmail;   //用户邮箱
    private Integer userSex;     //用户性别    1：男 0：女 null：未知
    private Integer roleId;         // 角色ID 逻辑外键
    private long registerTime;   // 注册时间
    private Boolean status;
}
