package com.example.myblog.mapper;

import com.example.myblog.vo.ReplyVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ReplyMapper {
    List<ReplyVo> findByRepliedUserId(int repliedUserId);  //根据当前用户查询未读回复
}
