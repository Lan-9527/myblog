package com.example.myblog.controller;

import com.example.myblog.component.DateTimeFormat;
import com.example.myblog.exception.ServiceException;
import com.example.myblog.po.Article;
import com.example.myblog.service.ArticleService;
import com.example.myblog.vo.ArticleVo;
import com.example.myblog.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 添加或者更新文章
     *
     * @param article
     * @return
     */
    @PostMapping("/addAndUpdate")
    public ResultVo addAndUpdate(Article article) {
        if (article.getArticleId() == null) article.setPublicTime(ZonedDateTime.now(ZoneId.of("Asia/Shanghai")).toEpochSecond());
        if (article.getClassifyId() == null) throw new ServiceException("请选择分类");
        if (article.getArticleTitle().length() > 50) throw new ServiceException("文章标题不能大于50个字符");
        article.setPublicTime(DateTimeFormat.toInstant());
        articleService.addAndUpdate(article);
        return ResultVo.success("添加文章成功");
    }

    /**
     * 通过Id删除文章
     *
     * @param id
     * @return
     */
    @GetMapping("/delById/{id}")
    public ResultVo delById(@PathVariable Integer id) {
        if (id == null) throw new ServiceException("删除失败，参数不能为null");
        if (articleService.findAllOrById(id).size() == 0) throw new ServiceException("删除失败，文章不存在");
        return ResultVo.success("删除成功");
    }

    /**
     * 通过文章ID查询文章
     * @param id
     * @return
     */
    @GetMapping("/findById/{id}")
    public ResultVo findById(@PathVariable Integer id){
        if (id == null) throw new ServiceException("ID不能为空");
        return ResultVo.successAndData(articleService.findAllOrById(id));
    }

    /**
     * 查询所有文章
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/findAll")
    public ResultVo findAll(@RequestParam(defaultValue = "1") Integer pageNum, Integer pageSize){
        List<ArticleVo> articleVoList = articleService.findAllOrById(null);
        PageHelper.startPage(pageNum,pageSize);
        return ResultVo.successAndData(new PageInfo<ArticleVo>(articleVoList));
    }
}
