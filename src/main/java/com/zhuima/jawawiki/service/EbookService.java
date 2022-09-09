package com.zhuima.jawawiki.service;


import com.github.pagehelper.PageHelper;
import com.zhuima.jawawiki.domain.Ebook;
import com.zhuima.jawawiki.domain.EbookExample;
import com.zhuima.jawawiki.mapper.EbookMapper;
import com.zhuima.jawawiki.req.EbookReq;
import com.zhuima.jawawiki.resp.EbookResp;
import com.zhuima.jawawiki.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class EbookService {
    @Autowired
    private EbookMapper ebookMapper;


    public List<EbookResp> list(EbookReq req) {

        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
//        System.out.println("Listing Ebook: " + req.getName());
//        criteria.andNameLike("%" + req.getName() + "%");

        if (!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%" + req.getName() + "%");
        }


        PageHelper.startPage(1, 3);
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);


//        List<EbookResp> repoList = new ArrayList<>();
//
//        for (Ebook ebook: ebookList) {
//            EbookResp ebookResp = new EbookResp();
//            BeanUtils.copyProperties(ebook, ebookResp);
//            repoList.add(ebookResp);
//        }

        List<EbookResp> repoList = CopyUtil.copyList(ebookList, EbookResp.class);
        return repoList;

    }


    public Ebook getById(Long id) {
        return ebookMapper.selectByPrimaryKey(id);
    }
}
