package com.example.myblog.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data       // 分类表
public class Classify {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer classifyId;     // 分类ID
    private String classifyName;        //分类名称
}
