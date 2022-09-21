package com.zhuima.jawawiki.controller;


import com.zhuima.jawawiki.req.UserLoginReq;
import com.zhuima.jawawiki.req.UserQueryReq;
import com.zhuima.jawawiki.req.UserResetPasswordReq;
import com.zhuima.jawawiki.req.UserSaveReq;
import com.zhuima.jawawiki.resp.CommonResp;
import com.zhuima.jawawiki.resp.PageResp;
import com.zhuima.jawawiki.resp.UserLoginResp;
import com.zhuima.jawawiki.resp.UserResp;
import com.zhuima.jawawiki.service.UserService;
import com.zhuima.jawawiki.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;


    @Autowired
    private SnowFlake snowFlake;


    /**
     * 新增或更新用户
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
     * 获取用户清单
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

    /**
     * 修改用户密码
     * @param req
     * @return
     */
    @PostMapping("user/reset-password")
    public CommonResp resetPassword(@Valid @RequestBody UserResetPasswordReq req) {
        // 密码加密操作
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp resp = new CommonResp<>();
        userService.resetPassword(req);
        return resp;
    }


    @DeleteMapping("user/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        userService.delete(id);
        return resp;
    }


    @PostMapping("auth/login")
    public CommonResp login(@Valid @RequestBody UserLoginReq req) {
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp<UserLoginResp> resp = new CommonResp<>();
        UserLoginResp userLoginResp = userService.login(req);

        Long token = snowFlake.nextId();
        logger.info("生成单点登录token：{}，并放入redis中", token);
        userLoginResp.setToken(token.toString());
        resp.setContent(userLoginResp);
        return resp;
    }


    @GetMapping("auth/logout/{token}")
    public CommonResp logout(@PathVariable String token) {
        CommonResp resp = new CommonResp<>();
        return resp;
    }


}

