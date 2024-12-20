package main.java.com.example.designpatterns.chp11_proxy.remote;

import java.util.Objects;
import java.util.Random;

public class HasQuarterState implements State {
    private final transient GumballMachine gumballMachine;
    private final transient Random randomWinner;

    public HasQuarterState(final GumballMachine gumballMachine) {
        this.gumballMachine = Objects.requireNonNull(gumballMachine);
        randomWinner = new Random(System.currentTimeMillis());
    }

    @Override
    public void insertQuarter() {
        System.out.println("동전은 한 개만 넣어주세요.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("동전이 반환됩니다.");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("손잡이를 돌리셨습니다.");

        final var winner = randomWinner.nextInt(10);

        if (winner == 0 && gumballMachine.getCount() > 1) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("알맹이가 나갈 수 없습니다.");
    }

    @Override
    public void refill(final int count) {
        System.out.println("리필할 수 없는 상태입니다.");
    }

    @Override
    public String toString() {
        return "동전 있음";
    }
}
