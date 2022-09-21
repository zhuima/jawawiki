package com.zhuima.jawawiki.resp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class UserResp {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String loginName;

    private String password;

    private String username;

}