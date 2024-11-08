package main.java.com.example.designpatterns.chp11_proxy.remote;

public interface State {
    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();

    void refill(int count);
}
