package com.zhuima.jawawiki.service;


import com.zhuima.jawawiki.domain.Book;
import com.zhuima.jawawiki.domain.User;
import com.zhuima.jawawiki.mapper.BookMapper;
import com.zhuima.jawawiki.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;


    public List<Book> list() {

        return bookMapper.selectByExample(null);
    }
}
