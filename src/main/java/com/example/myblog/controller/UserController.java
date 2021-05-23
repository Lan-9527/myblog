package com.example.myblog.controller;

import com.example.myblog.component.DateTimeFormat;
import com.example.myblog.component.MailComponent;
import com.example.myblog.exception.ServiceException;
import com.example.myblog.po.User;
import com.example.myblog.service.UserService;
import com.example.myblog.vo.ResultVo;
import com.example.myblog.vo.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    MailComponent mailComponent;
    @Autowired
    UserService userService;

    /**
     * 通过邮箱注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public ResultVo add(User user){
        ResultVo resultVo = addUser(user);
        User user1 = (User) resultVo.getData();
        user1.setStatus(false);
        mailComponent.sendMail(user1.getUserEmail(),user1.getUserId());
        return ResultVo.success("注意查看邮箱, 有效期为60秒");
    }
    @PostMapping("/addUser")
    public ResultVo addUser(User user){
        if(user.getUserName().length() > 8) throw new ServiceException("用户名长度不能大于8");
        if(userService.findByEmail(user.getUserEmail()) != null) throw new ServiceException("邮箱已存在");
        if(!user.getUserEmail().matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) throw new ServiceException("邮箱格式不正确");
        if(user.getUserPass() == null && user.getUserPass().trim().equals("")) throw new ServiceException("密码不能为空");
        user.setRegisterTime(DateTimeFormat.toInstant());
        user.setStatus(true);
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
        LocalDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Shanghai")).toLocalDateTime();
        User user = userService.findById(id);
        if (user == null){
            throw new ServiceException("激活失败");
        }
        LocalDateTime before = DateTimeFormat.toLocalDateTime(user.getRegisterTime());
        if(!before.plusSeconds(60).isBefore(now)){
            userService.delById(id);
            throw new ServiceException("已过期，请重新注册");
        }
        return ResultVo.success("注册成功");
    }

    /**
     * 查询所有用户
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/find")
    public ResultVo find(@RequestParam(defaultValue = "1") Integer  pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<UserVo> userVo = userService.findAll();
        PageInfo<UserVo> userVoPageInfo = new PageInfo<>(userVo);
        return ResultVo.successAndData(userVoPageInfo);
    }
    @GetMapping("/delById")
    public ResultVo delById(Integer id){
       User user =  userService.findById(id);
       if(user == null){
           throw new ServiceException("用户不存在");
       }
        userService.delById(id);
        return ResultVo.success( user.getUserName()+" 用户删除成功");
    }
    @GetMapping("/findByEmail/{email}")
    public ResultVo findByEmail(@PathVariable String email){
        return ResultVo.successAndData(userService.findByEmail(email));
    }

    @GetMapping("/findByUserName/{username}")
    public ResultVo findByUserName(@PathVariable String username){
        return ResultVo.successAndData(userService.findByUserName(username));
    }

}
