package main.java.com.example.designpatterns.chp11_proxy.remote;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    protected MyRemoteImpl() throws RemoteException {
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        return "Server say, 'Hey, " + name + "'!";
    }

    public static void main(String[] args) {
        try {
            final var service = new MyRemoteImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("RemoteHello", service);
            System.out.println("Service started...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
