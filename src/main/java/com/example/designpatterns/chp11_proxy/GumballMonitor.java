package main.java.com.example.designpatterns.chp11_proxy;

import java.util.Objects;

public class GumballMonitor {
    private final GumballMachine gumballMachine;

    public GumballMonitor(final GumballMachine gumballMachine) {
        this.gumballMachine = Objects.requireNonNull(gumballMachine);
    }

    public void report() {
        System.out.println("뽑기 기계 위치: " + gumballMachine.getLocation());
        System.out.println("뽑기 기계 위치: " + gumballMachine.getCount() + " 개");
        System.out.println("뽑기 기계 위치: " + gumballMachine.getState());
    }
}
