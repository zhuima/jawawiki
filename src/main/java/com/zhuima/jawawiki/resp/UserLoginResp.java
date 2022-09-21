package com.zhuima.jawawiki.resp;

import lombok.Data;

@Data
public class UserLoginResp {
    private Long id;

    private String loginName;

    private String username;

    private String token;


}