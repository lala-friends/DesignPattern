package main.java.com.example.designpatterns.decorator.coffee;

import main.java.com.example.designpatterns.decorator.Beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        super("House Blend");
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
