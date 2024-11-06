package main.java.com.example.designpatterns.chp10_state_pattern.state;

public class GumballMachine {
    private final NoQuarterState noQuarterState;
    private final HasQuarterState hasQuarterState;
    private final SoldState soldState;
    private final WinnerState winnerState;
    private final SoldOutState soldOutState;

    private State state;
    private int count = 0;

    public GumballMachine(final int count) {
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
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

    public void setCount(int count) {
        this.count = count;
    }

    void releaseBoll() {
        System.out.println("알맹이가 나가고 있습니다.");
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

    public WinnerState getWinnerState() {
        return winnerState;
    }

    public SoldOutState getSoldOutState() {
        return soldOutState;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n주식화사 왕뽑기\n");
        stringBuilder.append("자바로 돌아가는 2004년형 뽑기 기계\n");
        stringBuilder.append("남은 개수:").append(count).append("개\n");
        stringBuilder.append(state.toString()).append("\n");

        return stringBuilder.toString();
    }
}
