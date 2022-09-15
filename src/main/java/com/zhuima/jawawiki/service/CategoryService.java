package com.zhuima.jawawiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhuima.jawawiki.domain.Category;
import com.zhuima.jawawiki.domain.CategoryExample;
import com.zhuima.jawawiki.mapper.CategoryMapper;
import com.zhuima.jawawiki.req.CategoryQueryReq;
import com.zhuima.jawawiki.req.CategorySaveReq;
import com.zhuima.jawawiki.resp.CategoryResp;
import com.zhuima.jawawiki.resp.PageResp;
import com.zhuima.jawawiki.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public PageResp<CategoryResp> list(CategoryQueryReq req) {

        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        // System.out.println("Listing Category: " + req.getName());
        // criteria.andNameLike("%" + req.getName() + "%");

        if (!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%" + req.getName() + "%");
        }

        PageHelper.startPage(req.getPage(), req.getSize());
        List<Category> CategoryList = categoryMapper.selectByExample(categoryExample);

        PageInfo<Category> pageInfo = new PageInfo<>(CategoryList);

        List<CategoryResp> repoList = CopyUtil.copyList(CategoryList, CategoryResp.class);
        PageResp<CategoryResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(repoList);
        return pageResp;

    }

    /**
     * 新增或更新一个分类
     * 
     * @param req
     */
    public void save(CategorySaveReq req) {
        Category category = CopyUtil.copy(req, Category.class);
        if (ObjectUtils.isEmpty((req.getId()))) {
            // 新增
            categoryMapper.insert(category);
        } else {
            // 更新
            categoryMapper.updateByPrimaryKey(category);
        }

    }


    /**
     * 获取单个分类
     * @param id
     * @return
     */
    public Category getById(Long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    /**
     * 删除一个分类
     *
     * @param id
     * @return
     */
    public int deleteById(Long id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }
}
