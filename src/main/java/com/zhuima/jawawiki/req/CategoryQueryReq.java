package com.zhuima.jawawiki.req;


import lombok.Data;

@Data
public class CategoryQueryReq extends PageReq {
    private Long id;

    private Long parent;

    private String name;

    private Integer sort;


}