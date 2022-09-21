package com.zhuima.jawawiki.req;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class UserResetPasswordReq {

    private Long id;

    @NotEmpty(message = "【密码】不能为空")
    @Length(min=6, max=40, message = "【密码】长度为6~40位")
    @Pattern(regexp = "^(?![0-9+$])(?![a-zA-Z]+$)[0-9A-Za-z]{6,40}$", message = "【密码】至少包含数字和英文，长度6~40位")
    private String password;

}