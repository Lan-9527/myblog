package com.example.myblog.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data       // 角色表
public class Role {
    @Id
    private Integer roleId;
    private String roleName;        // 角色名
}
