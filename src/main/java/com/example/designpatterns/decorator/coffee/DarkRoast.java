package main.java.com.example.designpatterns.decorator.coffee;

import main.java.com.example.designpatterns.decorator.Beverage;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        super("Dark Roast");
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
