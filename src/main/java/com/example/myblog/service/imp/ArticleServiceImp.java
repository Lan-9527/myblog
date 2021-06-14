package com.example.myblog.service.imp;

import com.example.myblog.dao.ArticleDao;
import com.example.myblog.mapper.ArticleMapper;
import com.example.myblog.po.Article;
import com.example.myblog.service.ArticleService;
import com.example.myblog.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImp implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ArticleDao articleDao;
    @Override
    public void addAndUpdate(Article article) {
        articleDao.save(article);
    }

    @Override
    public void delById(int id) {
        articleMapper.delById(id);
    }

    @Override
    public List<ArticleVo> find(Article article) {
        return articleMapper.findAllOrById(article);
    }

    @Override
    public List<ArticleVo> findByTitle(String title) {
        return articleMapper.findByTitle(title);
    }

    @Override
    public int delByClassifyId(int classifyId) {
        return articleMapper.delByClassifyId(classifyId);
    }


}
