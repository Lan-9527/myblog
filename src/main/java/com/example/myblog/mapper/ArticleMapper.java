package com.example.myblog.mapper;

import com.example.myblog.po.Article;
import com.example.myblog.vo.ArticleVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ArticleMapper {
    List<ArticleVo> findAllOrById(Article article);      // 通过Id查询 Id为null 则查询所有
    int delById(int id);
    List<ArticleVo> findByTitle(String title);          // 通过标题查询文章
    int delByClassifyId(int classifyId);        //根据分类Id删除文章
}
