package com.example.myblog.controller;

import com.example.myblog.exception.ServiceException;
import com.example.myblog.po.Classify;
import com.example.myblog.service.ClassifyService;
import com.example.myblog.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/save")
    public ResultVo save(Classify classify){
        if (classify.getClassifyName().length() > 15) throw new ServiceException("分类名称不能大于15个字符");
        Classify classify1 = classifyService.addAndUpdate(classify);
        return ResultVo.successAndData(classify1);
    }

    /**
     * 通过分类ID删除分类
     * @param id
     * @return
     */
    @GetMapping("/delById/{id}")
    public ResultVo delById(@PathVariable Integer id){
        System.out.println(id);
        if (id == null && id == 0) throw new ServiceException("删除失败， 参数为空");
        classifyService.delById(id);
        return ResultVo.success("删除分类成功");
    }

    /**
     * 查询所有或通过分类ID查询
     * @param
     * @return
     */
    @GetMapping("/find")
    public ResultVo findAllOrById(Classify classify){
        if (classify.getClassifyId() == null) return ResultVo.successAndData(classifyService.findAll());
        return ResultVo.successAndData(classifyService.findById(classify.getClassifyId()));
    }
}
