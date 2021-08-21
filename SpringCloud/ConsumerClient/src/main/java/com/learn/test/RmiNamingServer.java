package com.learn.test;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RmiNamingServer {
    public static void main(String[] args) throws MalformedURLException, AlreadyBoundException, RemoteException {
        // 本地主机上的远程对象注册表Registry的实例
        LocateRegistry.createRegistry(1099);
        // 创建一个远程对象
        OrderService orderService = new OrderServiceImp();
        // 把远程对象注册到RMI注册服务器上，并命名为Hello
        //绑定的URL标准格式为：rmi://host:port/name
        Naming.bind("rmi://localhost:1099/OrderService", orderService);
        System.out.println("开启OrderService服务成功!");
    }
}
