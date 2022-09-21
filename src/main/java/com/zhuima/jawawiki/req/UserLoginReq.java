package com.zhuima.jawawiki.req;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class UserLoginReq {

    @NotEmpty(message = "【用户名】不能为空")
    private String loginName;

    @NotEmpty(message = "【密码】不能为空")
    @Length(min=6, max=40, message = "【密码】规则不正确")
    @Pattern(regexp = "^(?![0-9+$])(?![a-zA-Z]+$)[0-9A-Za-z]{6,40}$", message = "【密码】规则不正确")
    private String password;


}