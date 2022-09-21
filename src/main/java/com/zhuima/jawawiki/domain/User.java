package com.zhuima.jawawiki.domain;


import lombok.Data;

@Data
public class User {
    private Long id;

    private String loginName;

    private String username;

    private String password;

}