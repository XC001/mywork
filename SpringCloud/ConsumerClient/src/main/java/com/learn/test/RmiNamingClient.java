package com.learn.test;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiNamingClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        String remoteAddr="rmi://localhost:1099/OrderService";
        OrderService orderService = (OrderService) Naming.lookup(remoteAddr);
        Order order = orderService.findOrder();
        System.out.println(order);
    }
}
