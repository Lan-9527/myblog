package com.example.myblog.service;

import com.example.myblog.po.Role;

import java.util.List;

public interface RoleService {
    void addAndUpdate(Role role);
    void delById(Integer id);
    List<Role> findAll();
}
