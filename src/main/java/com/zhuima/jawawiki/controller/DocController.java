package com.zhuima.jawawiki.controller;


import com.zhuima.jawawiki.domain.Doc;
import com.zhuima.jawawiki.req.DocQueryReq;
import com.zhuima.jawawiki.req.DocSaveReq;
import com.zhuima.jawawiki.resp.CommonResp;
import com.zhuima.jawawiki.resp.DocResp;
import com.zhuima.jawawiki.resp.PageResp;
import com.zhuima.jawawiki.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class DocController {

    @Autowired
    private DocService docService;


    /**
     * 新增或更新文档
     * @param req
     * @return
     */
    @PostMapping("docs")
    public CommonResp save(@RequestBody DocSaveReq req) {
        CommonResp resp = new CommonResp<>();
        docService.save(req);
        return resp;
    }


    /**
     * 获取分类文档
     * @param req
     * @return
     */
    @GetMapping("docs")
    public CommonResp list(@Valid DocQueryReq req) {
        CommonResp<PageResp<DocResp>> resp = new CommonResp<>();
        PageResp<DocResp> list = docService.list(req);
        resp.setContent(list);
        return resp;
    }


    /**
     * 获取某个文档
     * @param id
     * @return
     */
    @GetMapping("doc/{id}")
    public Doc getById(@PathVariable Long id) {
        return docService.getById(id);
    }


    /**
     * 删除一个分类
     * @param id
     * @return
     */
    @DeleteMapping ("doc/{id}")
    public CommonResp deleteById(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        docService.deleteById(id);
        return resp;
    }

    /**
     * 删除一批文档
     * @param ids
     * @return
     */
    @DeleteMapping ("doc/list/{ids}")
    public CommonResp deleteByIds(@PathVariable String ids) {
        CommonResp resp = new CommonResp<>();
        List<String> list = Arrays.asList(ids.split(","));
        docService.deleteByIds(list);
        return resp;
    }


}

