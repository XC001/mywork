package com.learn.test;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserService extends Remote {
    String findUser() throws RemoteException;
}
