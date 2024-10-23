package main.java.com.example.designpatterns.decorator.coffee;

import main.java.com.example.designpatterns.decorator.Beverage;

public class Decaf extends Beverage {
    public Decaf() {
        super("Decaf");
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
