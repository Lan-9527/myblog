package com.example.myblog.service.imp;

import com.example.myblog.dao.ArticleDao;
import com.example.myblog.dao.ClassifyDao;
import com.example.myblog.mapper.ArticleMapper;
import com.example.myblog.po.Classify;
import com.example.myblog.service.ArticleService;
import com.example.myblog.service.ClassifyService;
import org.apache.ibatis.annotations.Arg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    private ClassifyDao classifyDao;
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public Classify addAndUpdate(Classify classify) {
        return classifyDao.saveAndFlush(classify);
    }

    @Override
    @Transactional
    public void delById(Integer id) {
        classifyDao.deleteById(id);
        articleMapper.delByClassifyId(id);
    }

    @Override
    public Classify findById(Integer id) {
        return classifyDao.findById(id).get();
    }

    @Override
    public List<Classify> findAll() {
        return classifyDao.findAll();
    }
}
