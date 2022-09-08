package com.zhuima.jawawiki.controller;


import com.zhuima.jawawiki.domain.Ebook;
import com.zhuima.jawawiki.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class EbookController {

    @Autowired
    private EbookService ebookService;


    @GetMapping("ebooks")
    public List<Ebook> list() {
        return ebookService.list();
    }


    @GetMapping("ebooks/{id}")
    public Ebook getById(@PathVariable Long id) {
        return ebookService.getById(id);
    }
}
