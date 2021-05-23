package com.example.myblog.service;

import com.example.myblog.po.Comment;
import com.example.myblog.vo.CommentReplyVo;
import com.example.myblog.vo.CommentVo;

import java.util.List;

public interface CommentService {
    void add(Comment comment);
    List<CommentVo> findAll();
    List<CommentReplyVo> findByArticleId(int id);
    int delById(int id);
}
