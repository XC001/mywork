package com.learn.controller;

import com.learn.pojo.User;
import com.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable long id) throws Exception {
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Thread.sleep(99999999);
        return userService.queryUser(id);
    }
}
