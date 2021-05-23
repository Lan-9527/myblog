package com.example.myblog.dao;

import com.example.myblog.po.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleDao extends JpaRepository<Article, Integer> {
}
