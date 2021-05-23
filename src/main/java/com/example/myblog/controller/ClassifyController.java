package com.example.myblog.controller;

import com.example.myblog.exception.ServiceException;
import com.example.myblog.po.Classify;
import com.example.myblog.service.ClassifyService;
import com.example.myblog.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classify")
public class ClassifyController {
    @Autowired
    private ClassifyService classifyService;
    /**
     * 添加或更新分类
     * @param classify
     * @return
     */
    @PostMapping("/addAndUpdate")
    public ResultVo addAndUpdate(Classify classify){
        if (classify.getClassifyName().length() > 15) throw new ServiceException("分类名称不能大于15个字符");
        classifyService.addAndUpdate(classify);
        return ResultVo.success("成功");
    }

    /**
     * 通过分类ID删除分类
     * @param id
     * @return
     */
    public ResultVo delById(Integer id){
        if (id == null) throw new ServiceException("删除失败， 参数为空");
        classifyService.delById(id);
        return ResultVo.success("删除分类成功");
    }

    /**
     * 查询所有或通过分类ID查询
     * @param id
     * @return
     */
    @GetMapping("/findAllOrById")
    public ResultVo findAllOrById(Integer id){
        if (id == null) return ResultVo.successAndData(classifyService.findAll());
        return ResultVo.successAndData(classifyService.findById(id));
    }
}
