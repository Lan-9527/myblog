package com.example.myblog.controller;

import com.example.myblog.component.DateTimeFormat;
import com.example.myblog.config.GetUserID;
import com.example.myblog.exception.ServiceException;
import com.example.myblog.po.Comment;
import com.example.myblog.service.CommentService;
import com.example.myblog.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/comment")
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
    /**
     * 添加评论
     * @param comment
     * @return
     */
    @PostMapping("/add")
    public ResultVo add(Comment comment){
        if (comment.getCommentId() != null) throw new NullPointerException("评论不能更新");
        if (comment.getCommentContent().length() > 300) throw new ServiceException("评论内容不能大于300字符");
        comment.setUserId(GetUserID.getUserVo().getUserId());
        comment.setCommentId(0);
        comment.setCommentTime(DateTimeFormat.toInstant());
        System.out.println(comment);
        commentService.add(comment);
        return ResultVo.success("评论成功");

    }

    @GetMapping("/find")
    public ResultVo find(){
        return ResultVo.successAndData(commentService.findAll());
    }

    /**
     * 通过文章查询评论回复
     * @param id
     * @return
     */
    @GetMapping("/findByArticleId")
    public ResultVo findCommentByArticleId(int id){
        return ResultVo.successAndData(commentService.findByArticleId(id));

    }
    @GetMapping("delById")
    public ResultVo delById(int[] id){
        System.out.println(id);
        if(commentService.delById(id)>0) return ResultVo.success("删除成功");
        return ResultVo.failMsg("删除失败");
    }
}
