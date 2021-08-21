package com.learn.test;

import java.rmi.RemoteException;

public class OrderServiceSubImp implements OrderServiceParent {
    UserService user = new UserServiceImp();
    @Override
    public Order findOrder() throws RemoteException {
        Order order = new Order();
        order.orderId = user.findUser()+"001";
        return order;
    }
}
