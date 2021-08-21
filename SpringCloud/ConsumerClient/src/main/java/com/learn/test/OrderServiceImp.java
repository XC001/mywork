package com.learn.test;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OrderServiceImp extends UnicastRemoteObject implements OrderService {

    protected OrderServiceImp() throws RemoteException {
    }

    @Override
    public Order findOrder() throws RemoteException {
        Order order = new Order();
        order.orderId = "001";
        return order;
    }
}
