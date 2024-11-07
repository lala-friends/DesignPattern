package main.java.com.example.designpatterns.chp11_proxy;

public class GumballMachineTestDrive {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("GumballMachine <name> <inventory>");
            System.out.println(1);
        }

        final var name = args[0];
        final var count = Integer.parseInt(args[1]);
        final var gumballMachine = new GumballMachine(name, count);
        final var monitor = new GumballMonitor(gumballMachine);

        monitor.report();
    }
}
