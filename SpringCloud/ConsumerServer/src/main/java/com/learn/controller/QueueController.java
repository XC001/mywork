package com.learn.controller;

import com.learn.queue.ActiveMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueController {

    @Autowired
    ActiveMQProducer activeMQProducer;

    @RequestMapping("/queue/{msg}")
    public String queue(@PathVariable String msg){
        activeMQProducer.send(msg);
        return msg;
    }
}
