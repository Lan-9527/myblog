package com.example.myblog.vo;

import com.example.myblog.po.User;
import lombok.Data;

@Data
public class UserVo extends User {
    private String roleName; //角色名称
}
