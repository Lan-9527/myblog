package com.example.myblog.service.imp;

import com.example.myblog.dao.ReplyDao;
import com.example.myblog.mapper.ReplyMapper;
import com.example.myblog.po.Reply;
import com.example.myblog.service.ReplyService;
import com.example.myblog.vo.ReplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImp implements ReplyService {
    @Autowired
    private ReplyDao replyDao;
    @Autowired
    private ReplyMapper replyMapper;
    @Override
    public void add(Reply reply) {
        replyDao.save(reply);
    }

    @Override
    public void delById(int id) {
        replyDao.deleteById(id);
    }
    @Override
    public List<ReplyVo> selByRepliedUserId(int id) {
        return replyMapper.findByRepliedUserId(id);
    }
}
