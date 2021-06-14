package com.example.myblog.controller;

import com.example.myblog.component.DateTimeFormat;
import com.example.myblog.exception.ServiceException;
import com.example.myblog.po.Article;
import com.example.myblog.service.ArticleService;
import com.example.myblog.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/save")
    public ResultVo addAndUpdate(Article article) {
        if (article.getArticleId() == null) {
            article.setArticleId(0);
            article.setPublicTime(DateTimeFormat.toInstant());
        }
        if (article.getClassifyId() == null) throw new ServiceException("请选择分类");
        if (article.getArticleTitle().length() > 50) throw new ServiceException("文章标题不能大于50个字符");
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
        Article article = new Article();
        article.setArticleId(id);
        if (articleService.find(article).size() == 0) throw new ServiceException("删除失败，文章不存在");
        return ResultVo.success("删除成功");
    }

    @GetMapping("/find")
    public ResultVo find(Article article){
        if (article.getArticleTitle() != null) return ResultVo.successAndData(articleService.findByTitle(article.getArticleTitle()));
        return ResultVo.successAndData((articleService.find(article)));
    }
}
