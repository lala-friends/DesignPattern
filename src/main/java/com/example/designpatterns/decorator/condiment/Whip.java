package main.java.com.example.designpatterns.decorator.condiment;

import main.java.com.example.designpatterns.decorator.Beverage;

public class Whip extends CondimentDecorator {
    private final Beverage beverage;

    public Whip(final Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.10;
    }
}
