package main.java.com.example.designpatterns.chp11_proxy.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {
    private final State noQuarterState;
    private final State hasQuarterState;
    private final State soldState;
    private final State soldOutState;
    private final State winnerState;

    private final String location;
    private int count;
    private State state;

    public GumballMachine(final String location, final int count) throws RemoteException {
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);
        winnerState = new WinnerState(this);

        this.location = location;
        this.count = count;
        if (count > 0) {
            this.state = noQuarterState;
        } else {
            this.state = soldOutState;
        }
    }

    void releaseBall() {
        System.out.println("알맹이가 나가고 있습니다.");
        if (count != 0) {
            count -= 1;
        }
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public String getLocation() {
        return location;
    }

    public int getCount() {
        return count;
    }

    public State getState() {
        return state;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setState(State state) {
        this.state = state;
    }
}
