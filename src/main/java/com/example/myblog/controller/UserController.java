package com.example.myblog.controller;

import com.example.myblog.component.DateTimeFormat;
import com.example.myblog.component.MailComponent;
import com.example.myblog.exception.ServiceException;
import com.example.myblog.po.User;
import com.example.myblog.service.UserService;
import com.example.myblog.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    MailComponent mailComponent;
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    /**
     * 通过邮箱注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public ResultVo register(User user){
        System.out.println(user);
        ResultVo resultVo = addUser(user);
        User user1 = (User) resultVo.getData();
        System.out.println(user1);
        mailComponent.sendMail(user1.getUserEmail(),user1.getUserId());
        return ResultVo.success("注意查看邮箱, 有效期为60秒");
    }
    @PostMapping("/add")
    public ResultVo addUser(User user){
        if(user.getUserName().length() > 8) throw new ServiceException("用户名长度不能大于8");
        if(!user.getUserEmail().matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) throw new ServiceException("邮箱格式不正确");
        if(user.getUserPass() == null && user.getUserPass().trim().equals("")) throw new ServiceException("密码不能为空");
        user.setUserPass(passwordEncoder.encode(user.getUserPass()));
        if(user.getUserId() == null) {
            user.setUserId(0);
            user.setRegisterTime(DateTimeFormat.toInstant());
            User user1 = userService.findByEmail(user.getUserEmail());
            if(user1 != null){
                if (!user1.isStatus()){
                    return register(user);
                }else {
                    throw new ServiceException("邮箱已存在");
                }
            }
        }
        if(user.getUserId() != 0) {
            if(!user.getUserEmail().equals(userService.findById(user.getUserId()).getUserEmail())){
                if(userService.findByEmail(user.getUserEmail()) != null) throw new ServiceException("邮箱已存在");
            }
        }
        User user1 = userService.addAndUpdate(user);
        return ResultVo.successAndData(user1);
    }
    /**
     * 通过Id激活邮箱
     * @param id
     * @return
     */
    @GetMapping("/active")
    public ResultVo active(int id){
        User user = userService.findById(id);
        if (user == null){
            throw new ServiceException("激活失败");
        }
        if(DateTimeFormat.toInstant()>user.getRegisterTime()+60){
            userService.delById(id);
            throw new ServiceException("已过期，请重新注册");
        }
        user.setStatus(true);
        userService.addAndUpdate(user);
        return ResultVo.success("注册成功");
    }

    /**
     *
     * @param
     * @return
     */
    @GetMapping("/find")
    public ResultVo find(User user){
        if(user.getUserId() == null) return ResultVo.successAndData(userService.findAll());
        return ResultVo.successAndData(userService.findById(user.getUserId()));
    }
    @GetMapping("/findByEmail")
    public ResultVo findByEmail(String email){
        return ResultVo.successAndData(userService.findByEmail(email));
    }

    @GetMapping("/findByUserName/{username}")
    public ResultVo findByUserName(@PathVariable String username){
        return ResultVo.successAndData(userService.findByUserName(username));
    }
    @GetMapping("/delByIdList")
    public ResultVo delByIdList(int[] id){
        userService.delByIdList(id);
        return ResultVo.success("删除成功");
    }

}
