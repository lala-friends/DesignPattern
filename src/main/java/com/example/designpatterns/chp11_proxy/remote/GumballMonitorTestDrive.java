package main.java.com.example.designpatterns.chp11_proxy.remote;

import java.rmi.Naming;

public class GumballMonitorTestDrive {
    public static void main(String[] args) {
        final String[] locations = {
                "rmi://santafe.mightygumball.com/gumballmachine",
                "rmi://boulder.mightygumball.com/gumballmachine",
                "rmi://seattle.mightygumball.com/gumballmachine"
        };
        final GumballMonitor[] monitors = new GumballMonitor[locations.length];
        for (int i = 0; i < locations.length; i++) {
            try {
                final var machine = (GumballMachineRemote) Naming.lookup(locations[i]);
                monitors[i] = new GumballMonitor(machine);
                System.out.println(monitors[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < monitors.length; i++) {
            monitors[i].report();
        }
    }
}
