package com.example.myblog.service.imp;

import com.example.myblog.dao.ClassifyDao;
import com.example.myblog.po.Classify;
import com.example.myblog.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    private ClassifyDao classifyDao;
    @Override
    public void addAndUpdate(Classify classify) {
        classifyDao.save(classify);
    }

    @Override
    public void delById(Integer id) {
        classifyDao.deleteById(id);
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
