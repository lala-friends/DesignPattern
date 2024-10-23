package main.java.com.example.designpatterns.decorator;

public abstract class Beverage {
    private String description = "Unknown Beverage";

    public Beverage() {
    }

    public Beverage(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
