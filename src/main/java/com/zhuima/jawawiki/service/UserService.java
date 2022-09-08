package com.zhuima.jawawiki.service;


import com.zhuima.jawawiki.domain.User;
import com.zhuima.jawawiki.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public List<User> list() {
        return userMapper.list();
    }
}
