package com.example.myblog.vo;

import com.example.myblog.po.Comment;
import lombok.Data;

import java.util.List;

//评论查询接收数据
@Data
public class CommentVo extends Comment {
    private String userName;        //用户名
    private String articleName;     //文章名称
}
