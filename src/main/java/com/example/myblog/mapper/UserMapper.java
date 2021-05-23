package com.example.myblog.mapper;

import com.example.myblog.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    List<UserVo> findAll(); //查询所有用户
    UserVo findByEamil(String user_email); //通过邮箱查询用户
    List<UserVo> findByUserName(String username);
}
