package com.example.myblog.controller;

import com.example.myblog.exception.ServiceException;
import com.example.myblog.po.Role;
import com.example.myblog.service.RoleService;
import com.example.myblog.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 添加或者更新管理员
     * @param role
     * @return
     */
    @PostMapping("/addAndUpdate")
    public ResultVo addAndUpdate(Role role){
        if (role.getRoleName().length() > 5) throw new ServiceException("管理员名称不能大于五个字符");
        roleService.addAndUpdate(role);
        return ResultVo.success("添加管理员成功");
    }

    /**
     *通过角色ID删除管理员
     * @param id
     * @return
     */
    @GetMapping("/delById")
    public ResultVo delById(Integer id){
        if(id == null) throw new ServiceException("参数不能为空");
        roleService.delById(id);
        return ResultVo.success("删除管理员成功");
    }

    /**
     * 查询所有角色
     * @return
     */
    @GetMapping("/findAll")
    public ResultVo findAll(){
        return ResultVo.successAndData(roleService.findAll());
    }
}
