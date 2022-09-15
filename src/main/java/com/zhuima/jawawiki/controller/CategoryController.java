package com.zhuima.jawawiki.controller;


import com.zhuima.jawawiki.domain.Category;
import com.zhuima.jawawiki.req.CategoryQueryReq;
import com.zhuima.jawawiki.req.CategorySaveReq;
import com.zhuima.jawawiki.resp.CategoryResp;
import com.zhuima.jawawiki.resp.CommonResp;
import com.zhuima.jawawiki.resp.PageResp;
import com.zhuima.jawawiki.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    /**
     * 新增或更新分类
     * @param req
     * @return
     */
    @PostMapping("categorys")
    public CommonResp save(@RequestBody CategorySaveReq req) {
        CommonResp resp = new CommonResp<>();
        categoryService.save(req);
        return resp;
    }


    /**
     * 获取分类清单
     * @param req
     * @return
     */
    @GetMapping("categorys")
    public CommonResp list(@Valid CategoryQueryReq req) {
        CommonResp<PageResp<CategoryResp>> resp = new CommonResp<>();
        PageResp<CategoryResp> list = categoryService.list(req);
        resp.setContent(list);
        return resp;
    }


    /**
     * 获取某个分类
     * @param id
     * @return
     */
    @GetMapping("category/{id}")
    public Category getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }


    /**
     * 删除一个分类
     * @param id
     * @return
     */
    @DeleteMapping ("category/{id}")
    public CommonResp deleteById(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        categoryService.deleteById(id);
        return resp;
    }



}

