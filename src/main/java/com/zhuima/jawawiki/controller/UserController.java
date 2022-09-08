package com.zhuima.jawawiki.controller;


import com.zhuima.jawawiki.domain.User;
import com.zhuima.jawawiki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("user_list")
    public List<User> list() {
        return userService.list();
    }
}
