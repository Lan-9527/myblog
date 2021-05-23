package com.example.myblog.vo;

import com.example.myblog.po.Article;
import lombok.Data;
//用于文章查询接收数据
@Data
public class ArticleVo extends Article {
    private String classifyName;
}
