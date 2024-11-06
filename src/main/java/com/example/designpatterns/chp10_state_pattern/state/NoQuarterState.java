package main.java.com.example.designpatterns.chp10_state_pattern.state;

import java.util.Objects;

public class NoQuarterState implements State {
    private final GumballMachine gumballMachine;

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
}
