package main.java.com.example.designpatterns.decorator.condiment;

import main.java.com.example.designpatterns.decorator.Beverage;

public class Soy extends CondimentDecorator {
    private final Beverage beverage;

    public Soy(final Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.15;
    }
}
