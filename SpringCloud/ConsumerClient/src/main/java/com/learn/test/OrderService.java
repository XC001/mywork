package com.learn.test;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OrderService extends Remote {
    Order findOrder() throws RemoteException;
}
