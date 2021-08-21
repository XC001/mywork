package com.learn.controller;

import com.learn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping("/myuser/{id}")
    public User getUser(@PathVariable long id){
        List<ServiceInstance> list = discoveryClient.getInstances("ConsumerServer");
        ServiceInstance serviceInstance = list.get(0);
        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/" + id;

        return restTemplate.getForObject(url, User.class);
//        return userFeignClient.getUser(id);
    }

}
