package main.java.com.example.designpatterns.chp11_proxy.remote;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class GumballMachineTestDrive {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }

        try {
            final var name = args[0];
            final var count = Integer.parseInt(args[1]);
            final GumballMachine gumballMachine = new GumballMachine(name, count);

            LocateRegistry.createRegistry(1099);
            Naming.rebind("//" + name + "/gumballmachine", gumballMachine);
            System.out.println("GumballMachine is ready!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
