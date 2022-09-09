package com.zhuima.jawawiki.req;

import lombok.Data;

@Data
public class EbookReq extends PageReq {
    private Long id;

    private String name;
    private String description;

}