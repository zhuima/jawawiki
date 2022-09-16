package com.zhuima.jawawiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhuima.jawawiki.domain.Doc;
import com.zhuima.jawawiki.domain.DocExample;
import com.zhuima.jawawiki.mapper.DocMapper;
import com.zhuima.jawawiki.req.DocQueryReq;
import com.zhuima.jawawiki.req.DocSaveReq;
import com.zhuima.jawawiki.resp.DocResp;
import com.zhuima.jawawiki.resp.PageResp;
import com.zhuima.jawawiki.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class DocService {
    @Autowired
    private DocMapper docMapper;

    public PageResp<DocResp> list(DocQueryReq req) {

        DocExample docExample = new DocExample();
        DocExample.Criteria criteria = docExample.createCriteria();
        // System.out.println("Listing Doc: " + req.getName());
        // criteria.andNameLike("%" + req.getName() + "%");

        if (!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%" + req.getName() + "%");
        }

        PageHelper.startPage(req.getPage(), req.getSize());
        List<Doc> DocList = docMapper.selectByExample(docExample);

        PageInfo<Doc> pageInfo = new PageInfo<>(DocList);

        List<DocResp> repoList = CopyUtil.copyList(DocList, DocResp.class);
        PageResp<DocResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(repoList);
        return pageResp;

    }

    /**
     * 新增或更新一个文档
     * 
     * @param req
     */
    public void save(DocSaveReq req) {
        Doc doc = CopyUtil.copy(req, Doc.class);
        if (ObjectUtils.isEmpty((req.getId()))) {
            // 新增
            docMapper.insert(doc);
        } else {
            // 更新
            docMapper.updateByPrimaryKey(doc);
        }

    }


    /**
     * 获取单个文档
     * @param id
     * @return
     */
    public Doc getById(Long id) {
        return docMapper.selectByPrimaryKey(id);
    }

    /**
     * 删除一个文档
     *
     * @param id
     * @return
     */
    public int deleteById(Long id) {
        return docMapper.deleteByPrimaryKey(id);
    }
}
