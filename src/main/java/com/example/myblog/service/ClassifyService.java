package com.example.myblog.service;

import com.example.myblog.po.Classify;

import java.util.List;

public interface ClassifyService {
    Classify addAndUpdate(Classify classify);
    void delById(Integer id);
    Classify findById(Integer id);
    List<Classify> findAll();
}
