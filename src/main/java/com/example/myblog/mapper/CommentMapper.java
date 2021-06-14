package com.example.myblog.mapper;

import com.example.myblog.vo.CommentReplyVo;
import com.example.myblog.vo.CommentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CommentMapper {
    List<CommentVo> findAll();      //查询所有评论
    List<CommentReplyVo> findByArticleId(int id);       // 根据文章Id查询评论回复表 一对多
    int delById(int[] id);
}
