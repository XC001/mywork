package com.learn.test;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OrderFakeService extends OrderService {
    Order findOrder() throws RemoteException;
}
