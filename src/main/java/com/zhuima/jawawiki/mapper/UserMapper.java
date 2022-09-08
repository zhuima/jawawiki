package com.zhuima.jawawiki.mapper;

import com.zhuima.jawawiki.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    public List<User> list();
}
