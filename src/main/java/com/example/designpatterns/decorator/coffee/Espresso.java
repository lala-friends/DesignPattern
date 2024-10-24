package main.java.com.example.designpatterns.decorator.coffee;

import main.java.com.example.designpatterns.decorator.Beverage;
import main.java.com.example.designpatterns.decorator.Size;

public class Espresso extends Beverage {
    private static final String DESCRIPTION = "Espresso";

    public Espresso() {
        super(DESCRIPTION, Size.GRANDE);
    }

    public Espresso(final Size size) {
        super(DESCRIPTION, size);
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
