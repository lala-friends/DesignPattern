package main.java.com.example.designpatterns.chp11_proxy.remote;

import java.io.Serializable;

public interface State extends Serializable {
    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();

    void refill(int count);
}
