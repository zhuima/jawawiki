package com.zhuima.jawawiki.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class DocSaveReq {
    private Long id;

    @NotEmpty(message="【电子书] 不能为空")
    private Long ebookId;

    @NotEmpty(message="【父文档] 不能为空")
    private Long parent;

    @NotEmpty(message="【名称] 不能为空")
    private String name;

    @NotEmpty(message="【顺序] 不能为空")
    private Integer sort;

    private Integer viewCount;

    private Integer voteCount;


    @NotEmpty(message="【内容] 不能为空")
    private String content;


}