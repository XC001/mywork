package com.learn.service;

import com.learn.mapper.UserMap;
import com.learn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMap userMap;

    public User queryUser(Long id){
        return userMap.selectByPrimaryKey(id);
    }
}
