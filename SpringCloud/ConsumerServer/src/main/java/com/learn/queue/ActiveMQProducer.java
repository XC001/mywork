package com.learn.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.DeliveryMode;

@Component
public class ActiveMQProducer {
    @Value("${activemq.queue}")
    private String queue;

    @Autowired
    JmsTemplate jmsTemplate;

    public void send(Object object){
        jmsTemplate.convertAndSend(queue, object);
    }
}
