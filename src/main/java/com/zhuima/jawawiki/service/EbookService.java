package com.zhuima.jawawiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhuima.jawawiki.domain.Ebook;
import com.zhuima.jawawiki.domain.EbookExample;
import com.zhuima.jawawiki.mapper.EbookMapper;
import com.zhuima.jawawiki.req.EbookQueryReq;
import com.zhuima.jawawiki.req.EbookSaveReq;
import com.zhuima.jawawiki.resp.EbookResp;
import com.zhuima.jawawiki.resp.PageResp;
import com.zhuima.jawawiki.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class EbookService {
    @Autowired
    private EbookMapper ebookMapper;

    public PageResp<EbookResp> list(EbookQueryReq req) {

        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        // System.out.println("Listing Ebook: " + req.getName());
        // criteria.andNameLike("%" + req.getName() + "%");

        if (!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%" + req.getName() + "%");
        }

        PageHelper.startPage(req.getPage(), req.getSize());
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);

        List<EbookResp> repoList = CopyUtil.copyList(ebookList, EbookResp.class);
        PageResp<EbookResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(repoList);
        return pageResp;

    }

    /**
     * 新增
     * 
     * @param req
     */
    public void save(EbookSaveReq req) {
        Ebook ebook = CopyUtil.copy(req, Ebook.class);
        if (ObjectUtils.isEmpty((req.getId()))) {
            // 新增
            ebookMapper.insert(ebook);
        } else {
            // 更新
            ebookMapper.updateByPrimaryKey(ebook);
        }

    }

    public Ebook getById(Long id) {
        return ebookMapper.selectByPrimaryKey(id);
    }

    /**
     * 删除一个书籍
     *
     * @param id
     * @return
     */
    public int deleteById(Long id) {
        return ebookMapper.deleteByPrimaryKey(id);
    }
}
