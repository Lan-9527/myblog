package com.example.myblog.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.net.Inet4Address;

@Entity
@Data       // 回复表
public class Reply {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer replyId;
    private String replyContent;    //回复内容
    private Integer replyUserId;       //回复用户ID
    private Integer repliedUserId;      //被回复用户ID
    private Long replyTime;          // 回复时间
    private Integer commentId;          // 对应的评论表 逻辑外键
    private int readed;             //1：已读 0：未读
}
