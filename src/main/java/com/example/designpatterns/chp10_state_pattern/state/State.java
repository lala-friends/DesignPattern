package main.java.com.example.designpatterns.chp10_state_pattern.state;

public interface State {
    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();

    void refill(int count);
}
