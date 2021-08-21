package com.learn.test;

import java.io.Serializable;
import java.rmi.RemoteException;

public class UserServiceImp implements UserService, Serializable {
    @Override
    public String findUser() throws RemoteException {
        return "User0001";
    }
}
