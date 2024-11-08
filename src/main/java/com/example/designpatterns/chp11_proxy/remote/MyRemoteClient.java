package main.java.com.example.designpatterns.chp11_proxy.remote;

import java.rmi.Naming;

public class MyRemoteClient {
    public static void main(String[] args) {
        new MyRemoteClient().go();
    }

    public void go() {
        try {
            final var service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
            final var s = service.sayHello("Tiffany");

            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
