package com.example.myblog.dao;

import com.example.myblog.po.Classify;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassifyDao extends JpaRepository<Classify, Integer> {
}
