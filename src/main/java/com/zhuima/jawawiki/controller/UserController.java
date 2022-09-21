package com.zhuima.jawawiki.controller;


import com.zhuima.jawawiki.req.UserQueryReq;
import com.zhuima.jawawiki.req.UserSaveReq;
import com.zhuima.jawawiki.resp.CommonResp;
import com.zhuima.jawawiki.resp.PageResp;
import com.zhuima.jawawiki.resp.UserResp;
import com.zhuima.jawawiki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 新增或更新书籍
     * @param req
     * @return
     */
    @PostMapping("users")
    public CommonResp save(@Valid @RequestBody UserSaveReq req) {
        // 密码加密操作
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp resp = new CommonResp<>();
        userService.save(req);
        return resp;
    }


    /**
     * 获取书籍清单
     * @param req
     * @return
     */
    @GetMapping("users")
    public CommonResp list(@Valid UserQueryReq req) {
        CommonResp<PageResp<UserResp>> resp = new CommonResp<>();
        PageResp<UserResp> list = userService.list(req);
        resp.setContent(list);
        return resp;
    }

}

