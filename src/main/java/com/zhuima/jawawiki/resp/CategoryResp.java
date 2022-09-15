package com.zhuima.jawawiki.resp;


import lombok.Data;

@Data
public class CategoryResp {
    private Long id;

    private Long parent;

    private String name;

    private Integer sort;


}