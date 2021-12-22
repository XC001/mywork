package com.learn.service;

import com.learn.mapper.UserMap;
import com.learn.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserMap userMap;

    public User queryUser(Long id){
        log.info("query user through database");
        return userMap.selectByPrimaryKey(id);
    }
}
