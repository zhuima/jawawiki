package com.zhuima.jawawiki.service;


import com.zhuima.jawawiki.domain.Ebook;
import com.zhuima.jawawiki.domain.EbookExample;
import com.zhuima.jawawiki.mapper.EbookMapper;
import com.zhuima.jawawiki.req.EbookReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EbookService {
    @Autowired
    private EbookMapper ebookMapper;


    public List<Ebook> list(EbookReq req) {

        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        System.out.println("Listing Ebook: " + req.getName());
        criteria.andNameLike("%" + req.getName() + "%");
        return ebookMapper.selectByExample(ebookExample);

    }


    public Ebook getById(Long id) {
        return ebookMapper.selectByPrimaryKey(id);
    }
}
