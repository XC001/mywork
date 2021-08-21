package com.learn.test;

import java.io.Serializable;

public class Order implements Serializable {
    public String orderId = "1";
//    public OrderDetail orderDetail = new OrderDetail();

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                '}';
    }
}
