package com.example.myblog.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data       // 分类表
public class Classify {
    @Id
    private Integer classifyId;     // 分类ID
    private String classifyName;        //分类名称
}
