package com.example.myblog.service;


import com.example.myblog.po.Article;
import com.example.myblog.vo.ArticleVo;

import java.util.List;

public interface ArticleService {
    void addAndUpdate(Article article);
    void delById(int id);
    List<ArticleVo> findAllOrById(Integer id);
    List<ArticleVo> findByTitle(String title);
}
