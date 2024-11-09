package main.java.com.example.designpatterns.chp11_proxy.remote;

import java.util.Objects;

public class NoQuarterState implements State {
    private final transient GumballMachine gumballMachine;

    public NoQuarterState(final GumballMachine gumballMachine) {
        this.gumballMachine = Objects.requireNonNull(gumballMachine);
    }

    @Override
    public void insertQuarter() {
        System.out.println("동전을 넣으셨습니다.");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("동전으르 넣어주세요.");
    }

    @Override
    public void turnCrank() {
        System.out.println("동전으르 넣어주세요.");
    }

    @Override
    public void dispense() {
        System.out.println("동전으르 넣어주세요.");
    }

    @Override
    public void refill(final int count) {
        System.out.println("리필할 수 없는 상태입니다.");
    }

    @Override
    public String toString() {
        return "동전 투입 대기중";
    }
}
