package com.example.myblog.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data       // 回复表
public class Reply {
    @Id
    private Integer replyId;
    private String replyContent;    //回复内容
    private  int replyUserId;       //回复用户ID
    private int repliedUserId;      //被回复用户ID
    private long replyTime;          // 回复时间
    private int commentId;          // 对应的评论表 逻辑外键
    private int articleId;          // 对应的文章  逻辑外键
    private int readed;             //1：已读 0：未读
}
