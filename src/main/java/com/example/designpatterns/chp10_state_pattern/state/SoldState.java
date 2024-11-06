package main.java.com.example.designpatterns.chp10_state_pattern.state;

import java.util.Objects;

public class SoldState implements State {
    private final GumballMachine gumballMachine;

    public SoldState(final GumballMachine gumballMachine) {
        this.gumballMachine = Objects.requireNonNull(gumballMachine);
    }

    @Override
    public void insertQuarter() {
        System.out.println("잠깐만 기다려 주세요. 알맹이가 나가고 있습니다.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("이미 알맹이를 뽑으셨습니다.");
    }

    @Override
    public void turnCrank() {
        System.out.println("손잡이는 한번만 돌려주세요.");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBoll();

        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("Oops, out of gumballs!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }

    @Override
    public void refill(final int count) {
        System.out.println("리필할 수 없는 상태입니다.");
    }

    @Override
    public String toString() {
        return "알맹이 판매중";
    }
}
