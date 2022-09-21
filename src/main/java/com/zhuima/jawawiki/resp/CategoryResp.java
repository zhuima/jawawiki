package com.zhuima.jawawiki.resp;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class CategoryResp {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private Long parent;

    private String name;

    private Integer sort;


}