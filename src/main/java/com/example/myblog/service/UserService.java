package com.example.myblog.service;

import com.example.myblog.po.User;
import com.example.myblog.vo.UserVo;

import java.util.List;

public interface UserService {
    User addAndUpdate(User user);
    void delById(int id);
    List<UserVo> findAll();
    User findById(int id);
    UserVo findByEmail(String user_email);
    List<UserVo> findByUserName(String username);
    void delByIdList(int[] id);
}
