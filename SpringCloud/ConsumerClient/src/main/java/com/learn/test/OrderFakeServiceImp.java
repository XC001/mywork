package com.learn.test;

import java.rmi.RemoteException;

public class OrderFakeServiceImp implements OrderFakeService{
    @Override
    public Order findOrder() throws RemoteException {
        Order order = new Order();
        order.orderId="123";
        return order;
    }
}
