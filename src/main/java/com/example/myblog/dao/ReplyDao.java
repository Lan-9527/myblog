package com.example.myblog.dao;

import com.example.myblog.po.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyDao extends JpaRepository<Reply,Integer> {
}
