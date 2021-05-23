package com.example.myblog.dao;

import com.example.myblog.po.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment, Integer> {
}
