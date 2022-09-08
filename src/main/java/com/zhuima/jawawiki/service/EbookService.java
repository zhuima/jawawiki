package com.zhuima.jawawiki.service;


import com.zhuima.jawawiki.domain.Ebook;
import com.zhuima.jawawiki.mapper.EbookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EbookService {
    @Autowired
    private EbookMapper ebookMapper;


    public List<Ebook> list() {

        return ebookMapper.selectByExample(null);

    }


    public Ebook getById(Long id) {
        return ebookMapper.selectByPrimaryKey(id);
    }
}
