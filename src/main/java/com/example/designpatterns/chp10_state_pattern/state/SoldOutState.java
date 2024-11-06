package main.java.com.example.designpatterns.chp10_state_pattern.state;

import java.util.Objects;

public class SoldOutState implements State {
    private final GumballMachine gumballMachine;

    public SoldOutState(final GumballMachine gumballMachine) {
        this.gumballMachine = Objects.requireNonNull(gumballMachine);
    }

    @Override
    public void insertQuarter() {
        System.out.println("죄송합니다. 매진되었습니다.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("죄송합니다. 매진되었습니다.");
    }

    @Override
    public void turnCrank() {
        System.out.println("죄송합니다. 매진되었습니다.");
    }

    @Override
    public void dispense() {
        System.out.println("알맹이가 나갈 수 없습니다.");
    }

    @Override
    public void refill(final int count) {
        gumballMachine.setCount(count);
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public String toString() {
        return "매진";
    }
}
