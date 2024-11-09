package main.java.com.example.designpatterns.chp11_proxy.remote;

import java.rmi.RemoteException;
import java.util.Objects;

public class GumballMonitor {
    private final GumballMachineRemote gumballMachine;

    public GumballMonitor(final GumballMachineRemote gumballMachine) {
        this.gumballMachine = Objects.requireNonNull(gumballMachine);
    }

    public void report() {
        try {
            System.out.println("뽑기 기계 위치: " + gumballMachine.getLocation());
            System.out.println("뽑기 기계 위치: " + gumballMachine.getCount() + " 개");
            System.out.println("뽑기 기계 위치: " + gumballMachine.getState());
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
