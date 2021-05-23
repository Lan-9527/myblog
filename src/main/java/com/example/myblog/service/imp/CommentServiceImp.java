package com.example.myblog.service.imp;

import com.example.myblog.dao.CommentDao;
import com.example.myblog.mapper.CommentMapper;
import com.example.myblog.po.Comment;
import com.example.myblog.service.CommentService;
import com.example.myblog.vo.CommentReplyVo;
import com.example.myblog.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImp implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public void add(Comment comment) {
        commentDao.save(comment);
    }

    @Override
    public List<CommentVo> findAll() {
        return commentMapper.findAll();
    }

    @Override
    public List<CommentReplyVo> findByArticleId(int id) {
        return commentMapper.findByArticleId(id);
    }

    @Override
    public int delById(int id) {
        return commentMapper.delById(id);
    }
}
