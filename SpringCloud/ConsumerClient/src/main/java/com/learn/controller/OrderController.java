package com.learn.controller;

import com.learn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private OrderFeignClient orderFeignClient;

    @RequestMapping("/order/{id}")
    public User getUser(@PathVariable long id){
//        List<ServiceInstance> list = discoveryClient.getInstances("ConsumerServer");
//        ServiceInstance serviceInstance = list.get(0);
//        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/" + id;
//
//        return restTemplate.getForObject(url, User.class);
        return orderFeignClient.getUser(id);
    }

}
