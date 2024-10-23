package main.java.com.example.designpatterns.decorator.condiment;

import main.java.com.example.designpatterns.decorator.Beverage;

public class Milk extends CondimentDecorator {
    private final Beverage beverage;

    public Milk(final Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.10;
    }
}
