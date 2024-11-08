package main.java.com.example.designpatterns.chp11_proxy.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemote extends Remote {
    String sayHello(String name) throws RemoteException;
}
