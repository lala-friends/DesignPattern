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
        switch (beverage.getSize()) {
            case TALL:
                return beverage.cost() + 0.1;
            case VENTI:
                return beverage.cost() + 0.2;
            case GRANDE:
            default:
                return beverage.cost() + 0.15;
        }
    }
}
