package com.example.myblog.service.imp;

import com.example.myblog.dao.UserDao;
import com.example.myblog.mapper.UserMapper;
import com.example.myblog.po.User;
import com.example.myblog.service.UserService;
import com.example.myblog.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserDao userDao;

    @Override
    public User addAndUpdate(User user) {
        return userDao.saveAndFlush(user);
    }

    @Override
    public void delById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public List<UserVo> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id).get();
    }

    @Override
    public UserVo findByEmail(String user_email) {
        return userMapper.findByEamil(user_email);
    }

    @Override
    public List<UserVo> findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

}


