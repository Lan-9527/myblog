package com.example.myblog.service.imp;

import com.example.myblog.dao.AttendanceDao;
import com.example.myblog.dao.UserDao;
import com.example.myblog.exception.ServiceException;
import com.example.myblog.mapper.UserMapper;
import com.example.myblog.po.User;
import com.example.myblog.service.UserService;
import com.example.myblog.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class UserServiceImp implements UserService, UserDetailsService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    AttendanceDao attendanceDao;
    @Autowired
    UserDao userDao;

    @Override
    public User addAndUpdate(User user) {
        return userDao.saveAndFlush(user);
    }

    @Override
    @Transactional
    public void delById(int id) {
        userDao.deleteById(id);
        attendanceDao.deleteByUserId(id);
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
        return userMapper.findByEmail(user_email);
    }

    @Override
    public List<UserVo> findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public void delByIdList(int[] id) {
        userMapper.delByIdList(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserVo userVo = findByEmail(s);
        System.out.println(userVo);
        return userVo;
    }
}


