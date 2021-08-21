package com.learn.controller;

import com.learn.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//指定提供服务方的服务名和降级处理类
@FeignClient(contextId = "order", value="ConsumerServer", fallback = OrderFailback.class)
public interface OrderFeignClient {
    //指定要访问的URL
    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable long id);
}
