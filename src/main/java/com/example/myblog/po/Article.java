package com.example.myblog.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

@Data // 文章表
public class Article {
    @Id
    private Integer articleId; // 文章ID
    private String articleTitle;    //文章标题
    private String articleContent;  //文章内容
    private Long publicTime;     //发表时间
    private Integer classifyId;     // 分类ID 逻辑外键
}
