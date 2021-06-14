package com.example.myblog.controller;

import com.example.myblog.component.DateTimeFormat;
import com.example.myblog.config.GetUserID;
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
        if (reply.getReplyId() != null) {
            Reply reply1 = replyService.findById(reply.getReplyId());
            reply1.setReaded(1);
            replyService.add(reply1);
            return ResultVo.success("成功");
        }
        if(reply.getReplyUserId() == reply.getRepliedUserId()) throw new ServiceException("自己回复自己，很好玩是不是");
        reply.setReplyTime(DateTimeFormat.toInstant());
        reply.setReplyId(0);
        reply.setReplyUserId(GetUserID.getUserVo().getUserId());
        Reply reply1 = replyService.add(reply);
        return ResultVo.successAndData(reply1);
    }
    @GetMapping("/delById")
    public ResultVo delById(int id){
        replyService.delById(id);
        return ResultVo.success("删除回复成功");
    }

    @GetMapping("/findByRepliedUserId")
    public ResultVo findByRepliedUserId(){
        return ResultVo.successAndData(replyService.selByRepliedUserId(GetUserID.getUserVo().getUserId()));
    }
}
