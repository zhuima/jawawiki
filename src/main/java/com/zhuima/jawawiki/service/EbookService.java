package com.zhuima.jawawiki.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhuima.jawawiki.domain.Ebook;
import com.zhuima.jawawiki.domain.EbookExample;
import com.zhuima.jawawiki.mapper.EbookMapper;
import com.zhuima.jawawiki.req.EbookReq;
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


    public PageResp<EbookResp> list(EbookReq req) {

        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
//        System.out.println("Listing Ebook: " + req.getName());
//        criteria.andNameLike("%" + req.getName() + "%");

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


    public Ebook getById(Long id) {
        return ebookMapper.selectByPrimaryKey(id);
    }
}
