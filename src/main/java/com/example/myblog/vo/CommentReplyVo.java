package com.example.myblog.vo;

import lombok.Data;

import java.util.List;
@Data
public class CommentReplyVo extends CommentVo{
    private List<ReplyVo> replyVoList;
}
