package com.example.myblog.controller;

import com.example.myblog.component.DateTimeFormat;
import com.example.myblog.exception.ServiceException;
import com.example.myblog.po.Reply;
import com.example.myblog.service.ReplyService;
import com.example.myblog.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;
    @PostMapping("/add")
    public ResultVo add(Reply reply) {
        if (reply.getReplyId() != null) throw new ServiceException("只能回复不能更新");
        reply.setReplyTime(DateTimeFormat.toInstant());
        replyService.add(reply);
        return ResultVo.success("回复成功");
    }
    @GetMapping("/delById")
    public ResultVo delById(int id){
        replyService.delById(id);
        return ResultVo.success("删除回复成功");
    }

    @GetMapping("/findByRepliedUser")
    public ResultVo findByRepliedUserId(int id){
        return ResultVo.successAndData(replyService.selByRepliedUserId(id));
    }
}
