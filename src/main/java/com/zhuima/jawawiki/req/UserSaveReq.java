package com.zhuima.jawawiki.req;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class UserSaveReq {
    private Integer id;

    @NotNull(message = "【用户名】不能为空")
    private String loginName;

    @NotNull(message = "【密码】不能为空")
    @Length(min=6, max=20, message = "【密码】长度为6~20位")
    @Pattern(regexp = "^(?![0-9+$])(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$", message = "【密码】至少包含数字和英文，长度6~20位")
    private String password;

    @NotNull(message = "【昵称】不能为空")
    private String username;

}