package main.java.com.example.designpatterns.decorator.coffee;

import main.java.com.example.designpatterns.decorator.Beverage;
import main.java.com.example.designpatterns.decorator.Size;

public class HouseBlend extends Beverage {
    private static final String DESCRIPTION = "House Blend";

    public HouseBlend() {
        super(DESCRIPTION, Size.GRANDE);
    }

    public HouseBlend(final Size size) {
        super(DESCRIPTION, size);
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
