package com.zhuima.jawawiki.controller;


import com.zhuima.jawawiki.domain.Book;
import com.zhuima.jawawiki.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("books")
    public List<Book> list() {
        return bookService.list();
    }
}
