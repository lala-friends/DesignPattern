package main.java.com.example.designpatterns.chp11_proxy.remote;

import java.util.Objects;

public class WinnerState implements State {
    private final transient GumballMachine gumballMachine;

    public WinnerState(final GumballMachine gumballMachine) {
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
        System.out.println("축하합니다! 알맹이를 하나 더 받으실 수 있습니다.");
        gumballMachine.releaseBall();

        if (gumballMachine.getCount() > 0) {
            gumballMachine.releaseBall();

            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                System.out.println("더 이상 알맹이가 없습니다.");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        } else {
            System.out.println("더 이상 알맹이가 없습니다.");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }

    @Override
    public void refill(final int count) {
        System.out.println("리필할 수 없는 상태입니다.");
    }

    @Override
    public String toString() {
        return "당첨";
    }
}
