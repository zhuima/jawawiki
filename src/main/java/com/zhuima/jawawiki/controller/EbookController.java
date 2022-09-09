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

@RestController
@RequestMapping("/")
public class EbookController {

    @Autowired
    private EbookService ebookService;


    @PostMapping("ebooks")
    public CommonResp save(@RequestBody EbookSaveReq req) {
        CommonResp resp = new CommonResp<>();
        ebookService.save(req);
        return resp;
    }



    @GetMapping("ebooks")
    public CommonResp list(EbookReq req) {
        CommonResp<PageResp<EbookResp>> resp = new CommonResp<>();
        PageResp<EbookResp> list = ebookService.list(req);
        resp.setContent(list);
        return resp;
    }





    @GetMapping("ebooks/{id}")
    public Ebook getById(@PathVariable Long id) {
        return ebookService.getById(id);
    }
}

