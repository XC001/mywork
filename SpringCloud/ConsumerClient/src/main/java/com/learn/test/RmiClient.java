package com.learn.test;

import java.math.BigDecimal;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiClient {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        String name = "OrderService";
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        OrderService orderService = (OrderService) registry.lookup(name);
        Order order = orderService.findOrder();
        System.out.println(order.toString());
    }
}
