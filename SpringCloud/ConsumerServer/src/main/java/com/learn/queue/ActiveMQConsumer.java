package com.learn.queue;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQConsumer {

    @JmsListener(destination = "${activemq.queue}")
    public void consume(String message){
        System.out.println(message);
    }
}
