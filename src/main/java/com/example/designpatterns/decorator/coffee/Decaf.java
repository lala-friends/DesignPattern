package main.java.com.example.designpatterns.decorator.coffee;

import main.java.com.example.designpatterns.decorator.Beverage;
import main.java.com.example.designpatterns.decorator.Size;

public class Decaf extends Beverage {
    private static final String DESCRIPTION = "Decaf";

    public Decaf() {
        super(DESCRIPTION, Size.GRANDE);
    }

    public Decaf(final Size size) {
        super(DESCRIPTION, size);
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
