package com.zhuima.jawawiki.req;

import lombok.Data;

@Data
public class DocSaveReq {
    private Long id;

    private Long ebookId;

    private Long parent;

    private String name;

    private Integer sort;

    private Integer viewCount;

    private Integer voteCount;


}