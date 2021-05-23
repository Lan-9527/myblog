package com.example.myblog.service;

import com.example.myblog.po.Reply;
import com.example.myblog.vo.ReplyVo;

import java.util.List;

public interface ReplyService {
    void add(Reply reply);
    void delById(int id);
    List<ReplyVo> selByRepliedUserId(int id);
}
