package com.learn.controller;

import com.learn.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserFailback implements UserFeignClient{
    @Override
    public User getUser(long id) {
        User user = new User();
        user.setId(2);
        user.setName("Failed");
        user.setAddr("Failed");
        return user;
    }
}
