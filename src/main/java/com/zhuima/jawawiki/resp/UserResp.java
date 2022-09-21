package com.zhuima.jawawiki.resp;

import lombok.Data;

@Data
public class UserResp {
    private Integer id;

    private String loginName;

    private String password;

    private String username;

}