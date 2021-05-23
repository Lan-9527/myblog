package com.example.myblog.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data       // 评论表
public class Comment {
    @Id
    private Integer commentId;
    private String commentContent;      // 评论内容
    private Integer userId;         //评论用户
    private Long commentTime;    // 评论时间
    private Integer articleId;      //对应的文章ID 逻辑外键
    private Integer readed;         //1:已读  0：未读
}
