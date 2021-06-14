package com.example.myblog.vo;

import com.example.myblog.po.Reply;
import lombok.Data;
//回复查询接收数据
@Data
public class ReplyVo extends Reply {
    private String replyUserName;   //回复人的ID
    private String repliedUserName;     //被回复人的ID
    private int articleId; //文章ID
    private String articleTitle;     //文章名称
}
