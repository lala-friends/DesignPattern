package main.java.com.example.designpatterns.chp10_state_pattern.state;

public class GumballMachine {
    private final NoQuarterState noQuarterState;
    private final HasQuarterState hasQuarterState;
    private final SoldState soldState;
    private final SoldOutState soldOutState;

    private State state;
    private int count = 0;

    public GumballMachine(final int count) {
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);

        this.count = count;

        if (count > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    void setState(final State state) {
        this.state = state;
    }

    void releaseBoll() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count -= 1;
        }
    }

    public NoQuarterState getNoQuarterState() {
        return noQuarterState;
    }

    public HasQuarterState getHasQuarterState() {
        return hasQuarterState;
    }

    public SoldState getSoldState() {
        return soldState;
    }

    public SoldOutState getSoldOutState() {
        return soldOutState;
    }

    public int getCount() {
        return count;
    }
}