package com.learn.controller;

import com.learn.pojo.User;
import com.learn.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(path="/user/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable long id) throws Exception {
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        log.debug(MDC.get("correlationId"));
        log.info("query user by id:"+id);
        return userService.queryUser(id);
    }

    @RequestMapping("/user/cust")
    @ResponseBody
    public User getUser(String user){
        log.info(user.toString());
        return new User();
    }
}
