package com.zhuima.jawawiki.controller;


import com.zhuima.jawawiki.domain.Ebook;
import com.zhuima.jawawiki.req.EbookReq;
import com.zhuima.jawawiki.req.EbookSaveReq;
import com.zhuima.jawawiki.resp.CommonResp;
import com.zhuima.jawawiki.resp.EbookResp;
import com.zhuima.jawawiki.resp.PageResp;
import com.zhuima.jawawiki.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class EbookController {

    @Autowired
    private EbookService ebookService;


    /**
     * 新增或更新书籍
     * @param req
     * @return
     */
    @PostMapping("ebooks")
    public CommonResp save(@RequestBody EbookSaveReq req) {
        CommonResp resp = new CommonResp<>();
        ebookService.save(req);
        return resp;
    }


    /**
     * 获取书籍清单
     * @param req
     * @return
     */
    @GetMapping("ebooks")
    public CommonResp list(@Valid EbookReq req) {
        CommonResp<PageResp<EbookResp>> resp = new CommonResp<>();
        PageResp<EbookResp> list = ebookService.list(req);
        resp.setContent(list);
        return resp;
    }


    /**
     * 获取某个书籍
     * @param id
     * @return
     */
    @GetMapping("ebooks/{id}")
    public Ebook getById(@PathVariable Long id) {
        return ebookService.getById(id);
    }


    /**
     * 删除一个书籍
     * @param id
     * @return
     */
    @DeleteMapping ("ebooks/{id}")
    public CommonResp deleteById(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        ebookService.deleteById(id);
        return resp;
    }



}

