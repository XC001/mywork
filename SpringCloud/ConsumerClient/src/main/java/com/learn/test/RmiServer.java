package com.learn.test;

import org.aspectj.weaver.ast.Or;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiServer {
    public static void main(String[] args) throws RemoteException {
        String orderServiceName = "OrderService";
        OrderServiceParent engine = new OrderServiceSubImp();
        OrderServiceParent stub1 =
                (OrderServiceParent) UnicastRemoteObject.exportObject(engine, 0);
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind(orderServiceName, stub1);
        System.out.println("OrderService bound");

//        String orderServiceName = "OrderService";
//        OrderServiceImp engine = new OrderServiceImp();
//        OrderService stub1 =
//                (OrderService) UnicastRemoteObject.exportObject(engine, 0);
//        Registry registry = LocateRegistry.createRegistry(1099);
//        registry.rebind(orderServiceName, stub1);
//        System.out.println("OrderService bound");

//        String userServiceName = "OrderService";
//        OrderFakeService userEngine = new OrderFakeServiceImp();
//        OrderFakeService stub2 =
//                (OrderFakeService) UnicastRemoteObject.exportObject(userEngine, 0);
//        Registry registry = LocateRegistry.createRegistry(1099);
//        registry.rebind(userServiceName, stub2);
//        System.out.println("UserService bound");
    }
}
