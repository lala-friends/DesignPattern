package main.java.com.example.designpatterns.chp3_decorator.coffee;

import main.java.com.example.designpatterns.chp3_decorator.Beverage;
import main.java.com.example.designpatterns.chp3_decorator.Size;

public class DarkRoast extends Beverage {
    private static final String DESCRIPTION = "Dark Roast";

    public DarkRoast() {
        super(DESCRIPTION, Size.GRANDE);
    }

    public DarkRoast(final Size size) {
        super(DESCRIPTION, size);
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
