package com.example.myblog.service.imp;

import com.example.myblog.dao.RoleDao;
import com.example.myblog.po.Role;
import com.example.myblog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public void addAndUpdate(Role role) {
        roleDao.save(role);
    }

    @Override
    public void delById(Integer id) {
        roleDao.deleteById(id);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
